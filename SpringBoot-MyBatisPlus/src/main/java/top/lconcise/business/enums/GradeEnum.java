package top.lconcise.business.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum GradeEnum {

    PRIMARY(1, "小学"),
    SECONDARY(2, "中学"),
    HIGH(3, "高中");

    @EnumValue // 存数据值
    private int code;
    @JsonValue // 返回json 中的值
    private String desc;

    GradeEnum(int code, String desc) {
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
