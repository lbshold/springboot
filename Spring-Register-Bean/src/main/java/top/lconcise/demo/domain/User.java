package top.lconcise.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * Created by liusj on 2019/7/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Component
public class User {

    private String name;
    private int age;
}
