package com.example.demo.lawdoc.entity;

import com.example.demo.pdf.FillContent;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Admin
 */
@Data
public class BaseDataTemplate implements Serializable {

    private static final long serialVersionUID = -9086060389791211543L;

    @ApiModelProperty(value="主键Id")
    private Long id;

    @ApiModelProperty(value="文书文号，案号")
    private String lawNum;

    @ApiModelProperty(value="生成方式")
    private int createType;

    @ApiModelProperty(value="文书名称")
    private String lawDocFileName;

    public FillContent generate() throws IllegalAccessException, IllegalArgumentException {
        Class<? extends BaseDataTemplate> aClass = this.getClass();
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
