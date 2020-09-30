package top.lconcise.domain;

import lombok.Data;

/**
 * Created by liusj on 2019/10/9
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    private GradeEnum gradeEnum;
}
