package top.lconcise.design_demo.performance_counter.report;

import com.google.gson.Gson;
import top.lconcise.design_demo.performance_counter.domain.Aggregator;
import top.lconcise.design_demo.performance_counter.domain.vo.RequestInfo;
import top.lconcise.design_demo.performance_counter.domain.vo.RequestStats;
import top.lconcise.design_demo.performance_counter.storage.MetricsStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: liusj
 * @date: 2022/3/7
 */
public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    // 第4个代码逻辑：定时触发第1、2、3代码逻辑的执行；
    public void startRepeatedReport(long periodSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(() -> {
            // 第1个代码逻辑：根据给定的时间区间，从数据库中拉取数据；
            long durationInMillis = durationInSeconds * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            long startTimeInMillis = endTimeInMillis - durationInMillis;
            Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
            Map<String, RequestStats> stats = new HashMap<>();
            for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
                String apiName = entry.getKey();
                List requestInfosPerApi = entry.getValue();
                // 第2个代码逻辑：根据原始数据，计算得到统计数据；
                RequestStats requestStats = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
                stats.put(apiName, requestStats);
            }
            // 第3个代码逻辑：将统计数据显示到终端（命令行或邮件）；
            System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
            Gson gson = new Gson();
            System.out.println(gson.toJson(stats));
        }, 0, periodSeconds, TimeUnit.SECONDS);
    }
}
