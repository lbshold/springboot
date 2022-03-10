package top.lconcise.design_demo.performance_counter.controller;

import org.springframework.util.StringUtils;
import top.lconcise.design_demo.performance_counter.domain.vo.RequestInfo;
import top.lconcise.design_demo.performance_counter.storage.MetricsStorage;

/**
 * 负责提供 API，来采集接口请求的原始数据
 *
 * @author: liusj
 * @date: 2022/3/7
 */
public class MetricsCollector {

    private MetricsStorage metricsStorage; // 基于接口而非实现编程

    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    // 用一个函数代替了最小原型中的两个函数
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isEmpty(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
