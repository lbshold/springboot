package top.lconcise.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by liusj on 2019/7/1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private String name;
    private Integer age;
}
