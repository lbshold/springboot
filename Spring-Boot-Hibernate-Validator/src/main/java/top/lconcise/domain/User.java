package top.lconcise.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by liusj on 2019/8/14
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 6523421519574577128L;

    @NotBlank(message = "{required}")
    private String name;
    @Email(message = "{invalid}")
    private String email;

}
