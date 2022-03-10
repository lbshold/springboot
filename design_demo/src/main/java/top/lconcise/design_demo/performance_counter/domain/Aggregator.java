package top.lconcise.design_demo.performance_counter.domain;

import top.lconcise.design_demo.performance_counter.domain.vo.RequestInfo;
import top.lconcise.design_demo.performance_counter.domain.vo.RequestStats;

import java.util.Collections;
import java.util.List;

/**
 * 根据原始数据计算统计数据
 *
 * @author: liusj
 * @date: 2022/3/7
 */
public class Aggregator {

    public static RequestStats aggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;

        for (RequestInfo requestInfo : requestInfos) {
            ++count;
            double respTime = requestInfo.getResponseTime();
            if (maxRespTime < respTime) {
                maxRespTime = respTime;
            }
            if (minRespTime > respTime) {
                minRespTime = respTime;
            }
            sumRespTime += respTime;
        }
        if (count != 0) {
            avgRespTime = sumRespTime / count;
        }
        long tps = count / (durationInMillis * 1000);
        Collections.sort(requestInfos, ((o1, o2) -> {
            double diff = o1.getResponseTime() - o2.getResponseTime();
            if (diff < 0.0) {
                return -1;
            } else if (diff > 0.0) {
                return 1;
            } else {
                return 0;
            }
        }));
        int idx999 = (int) (count * 0.999);
        int idx99 = (int) (count * 0.99);
        if (count != 0) {
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }
        RequestStats requestStats = new RequestStats();
        requestStats.setMaxResponseTime(maxRespTime);
        requestStats.setMinResponseTime(minRespTime);
        requestStats.setAvgResponseTime(avgRespTime);
        requestStats.setP999ResponseTime(p999RespTime);
        requestStats.setP99ResponseTime(p99RespTime);
        requestStats.setCount(count);
        requestStats.setTps(tps);
        return requestStats;
    }
}
