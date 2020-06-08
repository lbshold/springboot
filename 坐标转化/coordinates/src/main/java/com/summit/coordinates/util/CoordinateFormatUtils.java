package com.summit.coordinates.util;

import org.apache.logging.log4j.util.Strings;

/**
 * Created by liusj on 2019/5/27
 * <p>
 * 经纬度格式转换工具类.
 */
public class CoordinateFormatUtils {

    /**
     * 经纬度转化，度分秒转度.
     * 如：108°13′21″= 108.2225
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
            m = getM(jwd, m);
            //不同单位的秒，可扩展
            s = getS(jwd, s);
            jwd = String.valueOf(d + m / 60 + s / 60 / 60);//计算并转换为string
        }
        return jwd;
    }

    private static double getS(String jwd, double s) {
        if (jwd.contains("″")) {//正常的″
            //有时候没有分 如：112°10.25″
            s = jwd.contains("′") ? Double.parseDouble(jwd.split("′")[1].split("″")[0]) : Double.parseDouble(jwd.split("'")[1].split("″")[0]);
        } else if (jwd.contains("〃")) {
            s = jwd.contains("′") ? Double.parseDouble(jwd.split("′")[1].split("〃")[0]) : Double.parseDouble(jwd.split("'")[1].split("〃")[0]);
        } else if (jwd.contains("\"")) {
            s = jwd.contains("′") ? Double.parseDouble(jwd.split("′")[1].split("\"")[0]) : Double.parseDouble(jwd.split("'")[1].split("\"")[0]);
        }
        return s;
    }

    private static double getM(String jwd, double m) {

        if (jwd.contains("′")) {//正常的′
            m = Double.parseDouble(jwd.split("°")[1].split("′")[0]);
        } else if (jwd.contains("'")) {//特殊的'
            m = Double.parseDouble(jwd.split("°")[1].split("'")[0]);
        }
        return m;
    }

    /**
     * 经纬度转换，度分转度度.
     * 如：112°30.4128 = 112.50688
     */
    public static String DmTurnDD(String jwd) {
        jwd = jwd.replace("′", "");
        jwd = jwd.replace("'", "");
        if (Strings.isNotEmpty(jwd) && (jwd.contains("°"))) {//如果不为空并且存在度单位
            double d = 0, m = 0;
            d = Double.parseDouble(jwd.split("°")[0]);
            m = Double.parseDouble(jwd.split("°")[1]) / 60;
            jwd = String.valueOf(d + m);
        }
        return jwd;
    }

    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：米)
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(double lat1, double lng1, double lat2,
                                     double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }
}
