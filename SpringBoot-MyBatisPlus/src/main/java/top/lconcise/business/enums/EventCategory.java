package top.lconcise.business.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 现场执法事件类型枚举.
 */
public enum EventCategory {

    SANITATION_MANAGEMENT(1, "城市市容环境卫生管理"),
    RUBBISH_MANAGEMENT(2, "城市建筑垃圾管理"),
    VIRESCENCE_MANAGEMENT(3, "城市园林绿化管理"),
    MUNICIPAL_MANAGEMENT(4, "城市市政管理"),
    PLAN_MANAGEMENT(5, "城市规划管理"),
    TRAFFIC_MANAGEMENT(6, "公共交通管理"),
    HISTORY_MANAGEMENT(7, "历史文化名称保护管理");

    @EnumValue
    private int code;
    private String desc;

    EventCategory(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
