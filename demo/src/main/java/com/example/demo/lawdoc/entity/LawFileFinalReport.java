package com.example.demo.lawdoc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 案件-文书模板-结案报告
 * </p>
 *
 * @author liusj
 * @since 2022-05-12
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "LawFileFinalReport对象", description = "")
public class LawFileFinalReport extends BaseDataTemplate {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "出生日期")
    private String birthday;

    @ApiModelProperty(value = "证件号")
    private String idCardNo;

    @ApiModelProperty(value = "执行方式")
    private String modeOfExecution;


}
