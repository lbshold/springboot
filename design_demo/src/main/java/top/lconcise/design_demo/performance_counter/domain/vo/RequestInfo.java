package top.lconcise.design_demo.performance_counter.domain.vo;

import lombok.Data;

/**
 * @author: liusj
 * @date: 2022/3/7
 */
@Data
public class RequestInfo {

    private String apiName;

    private double responseTime;

    private double timestamp;

    public RequestInfo() {

    }

    public RequestInfo(String apiName, double responseTime, double timestamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.timestamp = timestamp;
    }
}
