package top.lconcise.design_demo.alert.improved_code;

import lombok.Data;

/**
 * @author: liusj
 * @date: 2022/3/14
 */
@Data
public class ApiStatInfo {

    private String api;
    private long requestCount;
    private long errorCount;
    private long durationSeconds;
}
