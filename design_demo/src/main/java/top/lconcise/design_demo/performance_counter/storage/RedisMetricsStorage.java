package top.lconcise.design_demo.performance_counter.storage;

import top.lconcise.design_demo.performance_counter.domain.vo.RequestInfo;

import java.util.List;
import java.util.Map;

/**
 * @author: liusj
 * @date: 2022/3/7
 */
public class RedisMetricsStorage implements MetricsStorage {

    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {

    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimeMills, long endTimeMills) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeMills, long endTimeMills) {
        return null;
    }
}
