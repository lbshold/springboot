package com.example.demo.lawdoc.entity;

import com.example.demo.pdf.FillContent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 案件-主表
 * </p>
 *
 * @author liusj
 * @since 2022-05-13
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Info对象", description = "案件-主表")
public class LawDocInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "案号/文件编号")
    private String lawcaseNum;

    @ApiModelProperty(value = "案件名称")
    private String lawcaseName;

    @ApiModelProperty(value = "案件类型")
    private Boolean lawcaseType;

    @ApiModelProperty(value = "承办人")
    private String undertaker;

    @ApiModelProperty(value = "承办人Id")
    private Long undertakerId;

    @ApiModelProperty(value = "立案时间")
    private LocalDateTime lawcaseStartDate;

    @ApiModelProperty(value = "结案时间")
    private LocalDateTime lawcaseEndDate;

    @ApiModelProperty(value = "卷宗附件")
    private String archiveFile;

    @ApiModelProperty(value = "证据附件")
    private String evidenceFile;

    @ApiModelProperty(value = "状态")
    private Boolean status;

    @ApiModelProperty(value = "处理结果")
    private String archiveHandleResult;

    @ApiModelProperty(value = "保管期限")
    private LocalDateTime archiveBgDate;

    @ApiModelProperty(value = "归档号")
    private String archiveNum;

    @ApiModelProperty(value = "目录号")
    private String archiveFolderNum;

    @ApiModelProperty(value = "全宗号")
    private String archiveQzNum;

    @ApiModelProperty(value = "案卷号")
    private String archiveAjNum;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime creationDate;

    @ApiModelProperty(value = "创建人")
    private Long createdBy;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime lastUpdateDate;

    @ApiModelProperty(value = "最后更新人")
    private Long lastUpdatedBy;

    @ApiModelProperty(value = "是否删除：1：是，2：否")
    private Integer deleteFlag;

    private Integer fileNum;

    private Integer page;

    public FillContent generate() throws IllegalAccessException, IllegalArgumentException {
        Class<? extends LawDocInfo> aClass = this.getClass();
        Map<String, String> contentMap = new HashMap<>();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(this);
            if(value!=null){
                contentMap.put(name, value.toString());
            }
        }
        FillContent fillContent = new FillContent();
        fillContent.setContentMap(contentMap);
        return fillContent;
    }
}
