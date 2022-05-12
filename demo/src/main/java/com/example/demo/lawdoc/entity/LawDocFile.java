package com.example.demo.lawdoc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 案件-文书主表
 * </p>
 *
 * @author liusj
 * @since 2022-05-12
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "File对象", description = "案件-文书主表")
public class LawDocFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "模板表主键id")
    private Long templateId;

    @ApiModelProperty(value = "文书文号")
    private String lawNum;

    @ApiModelProperty(value = "文书名称")
    private String fileName;

    @ApiModelProperty(value = "文书状态")
    private Integer fileStatus;

    @ApiModelProperty(value = "公示状态                                           ")
    private Integer publicityStatus;

    @ApiModelProperty(value = "推送状态")
    private Integer pushStatus;

    @ApiModelProperty(value = "序号")
    private Integer sort;

    @ApiModelProperty(value = "材料名称")
    private String dataName;

    @ApiModelProperty(value = "页号")
    private String pageNum;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "创建人")
    private Long createBy;

    @ApiModelProperty(value = "更新人")
    private Long updateBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除：1：是，0：否")
    private Integer isDeleted;

    @ApiModelProperty(value = "制作时间")
    private LocalDateTime saveTime;

    @ApiModelProperty(value = "模板标记Id")
    private Long mark;


}
