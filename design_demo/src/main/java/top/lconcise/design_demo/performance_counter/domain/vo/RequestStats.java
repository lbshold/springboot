package top.lconcise.design_demo.performance_counter.domain.vo;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author: liusj
 * @date: 2022/3/8
 */
@Data
public class RequestStats {

    private double maxResponseTime;
    private double minResponseTime;
    private double avgResponseTime;
    private double p999ResponseTime;
    private double p99ResponseTime;
    private long count;
    private long tps;
}
