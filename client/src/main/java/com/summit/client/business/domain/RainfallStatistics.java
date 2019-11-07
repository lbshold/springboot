package com.summit.client.business.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by liusj on 2019/11/7
 * <p>
 * 雨量统计表.
 */
//@Data
//@TableName(value = "st_pptn_r")
public class RainfallStatistics {

    @ApiModelProperty(value = "测站编码")
    private String STCD;
    @ApiModelProperty(value = "时间")
    private String TM;
    @ApiModelProperty(value = "时段降水量")
    private String DRP;
    @ApiModelProperty(value = "时段长")
    private String INTV;
    @ApiModelProperty(value = "降水历时")
    private String PDR;
    @ApiModelProperty(value = "日降水量")
    private String DYP;
    @ApiModelProperty(value = "天气状况")
    private double WTH;
    @ApiModelProperty(value = "累计雨量")
    private double ARP;
    @ApiModelProperty(value = "今日雨量")
    private double TRP;
    @ApiModelProperty(value = "1h累计雨量")
    private double HARP;
    private String FLAG;
}
