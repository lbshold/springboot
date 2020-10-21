package top.lconcise.business.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.lconcise.business.enums.GradeEnum;

import java.util.Date;

/**
 * Created by liusj on 2019/10/9
 */
@Data
@TableName("sys_user") // 自定义的表名，这里需要加注释
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @ApiModelProperty(value = "教育情况")
    @TableField("grade_enum")
    private GradeEnum gradeEnum;

    @TableField("gmt_create")
    private Date gmtCreate;
    @TableField("gmt_modified")
    private Date gmtModified;

}
