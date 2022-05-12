package com.example.demo.lawdoc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 案件-文书模板-卷内备考表
 * </p>
 *
 * @author liusj
 * @since 2022-05-12
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="LawFileRemarks对象", description="卷内备考表")
public class LawFileRemarks extends BaseDataTemplate {

    @ApiModelProperty(value = "立卷人")
    private String createBy;

    @ApiModelProperty(value = "检查人")
    private String checkBy;

    @ApiModelProperty(value = "立案时间")
    private String createTime;

    @ApiModelProperty(value = "情况说明")
    private String desc;


}
