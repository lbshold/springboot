package com.summit.coordinates.util;

import org.apache.logging.log4j.util.Strings;

/**
 * Created by liusj on 2019/5/27
 * <p>
 * 经纬度格式转换工具类.
 */
public class CoordinateUtil {

    /**
     * 经纬度转化，度分秒转度.
     *
     * @param jwd
     * @return
     */
    public static String DmsTurnDD(String jwd) {
        if (Strings.isNotEmpty(jwd) && (jwd.contains("°"))) {//如果不为空并且存在度单位
            //计算前进行数据处理
            jwd = jwd.replace("E", "").replace("N", "").replace(":", "").replace("：", "");
            double d = 0, m = 0, s = 0;
            d = Double.parseDouble(jwd.split("°")[0]);
            //不同单位的分，可扩展
            if (jwd.contains("′")) {//正常的′
                m = Double.parseDouble(jwd.split("°")[1].split("′")[0]);
            } else if (jwd.contains("'")) {//特殊的'
                m = Double.parseDouble(jwd.split("°")[1].split("'")[0]);
            }
            //不同单位的秒，可扩展
            if (jwd.contains("″")) {//正常的″
                //有时候没有分 如：112°10.25″
                s = jwd.contains("′") ? Double.parseDouble(jwd.split("′")[1].split("″")[0]) : Double.parseDouble(jwd.split("°")[1].split("″")[0]);
            } else if (jwd.contains("''")) {//特殊的''
                //有时候没有分 如：112°10.25''
                s = jwd.contains("'") ? Double.parseDouble(jwd.split("'")[1].split("''")[0]) : Double.parseDouble(jwd.split("°")[1].split("''")[0]);
            }
            jwd = String.valueOf(d + m / 60 + s / 60 / 60);//计算并转换为string

        }
        return jwd;
    }

    /**
     * 经纬度转换，度分转度度.
     * 如：112°30.4128 = 112.50688
     */
    public static String DmTurnDD(String jwd) {
        jwd = jwd.replace("′", "");
        if (Strings.isNotEmpty(jwd) && (jwd.contains("°"))) {//如果不为空并且存在度单位
            double d = 0, m = 0;
            d = Double.parseDouble(jwd.split("°")[0]);
            m = Double.parseDouble(jwd.split("°")[1]) / 60;
            jwd = String.valueOf(d + m);
        }
        return jwd;
    }
}
