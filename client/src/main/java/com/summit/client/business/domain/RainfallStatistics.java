package com.summit.client.business.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

/**
 * Created by liusj on 2019/11/7
 * <p>
 * 雨量统计表.
 */
@Data
@TableName(value = "st_pptn_r")
public class RainfallStatistics {

    @ApiModelProperty(value = "测站编码")
    @TableField(value = "STCD")
    private String stcd;
    @ApiModelProperty(value = "时间")
    @TableField(value = "TM")
    private String tm;
    @ApiModelProperty(value = "时段降水量")
    @TableField(value = "DRP")
    private String drp;
    @ApiModelProperty(value = "时段长")
    @TableField(value = "INTV")
    private String inty;
    @ApiModelProperty(value = "降水历时")
    @TableField(value = "PDR")
    private String pdr;
    @ApiModelProperty(value = "日降水量")
    @TableField(value = "DYP")
    private String dyp;
    @ApiModelProperty(value = "天气状况")
    @TableField(value = "WTH")
    private double wth;
    @ApiModelProperty(value = "累计雨量")
    @TableField(value = "ARP")
    private double arp;
    @ApiModelProperty(value = "今日雨量")
    @TableField(value = "TRP")
    private double trp;
    @ApiModelProperty(value = "1h累计雨量")
    @TableField(value = "HARP")
    private double harp;
    @TableField(value = "FLAG")
    private String flag;
}
