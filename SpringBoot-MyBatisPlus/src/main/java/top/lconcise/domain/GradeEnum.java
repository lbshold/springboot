package top.lconcise.domain;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Data;

public enum GradeEnum {

    PRIMARY(1,"小学"),
    SECONDARY(2,"中学"),
    HIGH(3,"高中");

    @EnumValue
    private int code;
    private String desc;

    GradeEnum(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
