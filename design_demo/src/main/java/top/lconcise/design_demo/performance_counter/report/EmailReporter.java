package top.lconcise.design_demo.performance_counter.report;

import top.lconcise.design_demo.performance_counter.domain.Aggregator;
import top.lconcise.design_demo.performance_counter.domain.vo.RequestInfo;
import top.lconcise.design_demo.performance_counter.domain.vo.RequestStats;
import top.lconcise.design_demo.performance_counter.storage.MetricsStorage;

import java.util.*;

/**
 * @author: liusj
 * @date: 2022/3/7
 */
public class EmailReporter {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public EmailReporter(MetricsStorage metricsStorage, EmailSender emailSender) {
        this.metricsStorage = metricsStorage;
        this.emailSender = emailSender;
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    public void startDailyReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                Map<String, RequestStats> stats = new HashMap<>();
                for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
                    String apiName = entry.getKey();
                    List<RequestInfo> requestInfosPerApi = entry.getValue();
                    RequestStats requestStats = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
                    stats.put(apiName, requestStats);
                }
                // TODO:格式化为html格式，并且发送邮件
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }
}
