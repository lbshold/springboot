package com.summit.coordinates.util;

import com.summit.coordinates.entity.MyCoordinate;

/**
 * Created by liusj on 2020/6/10
 */
public class MyUitls {

    /**
     * 国际坐标(WGS84)转火星坐标系(GCJ02).
     *
     * @param myCoordinate
     * @return
     */
    public static MyCoordinate wgs84ToGcj02Copy(MyCoordinate myCoordinate) {
        CoordinateConvertUtil.Point point = CoordinateConvertUtil.wgs84ToGcj02(Double.valueOf(myCoordinate.getLongitude()), Double.valueOf(myCoordinate.getLatitude()));
        myCoordinate.setLatitude(String.valueOf(point.getLat()));
        myCoordinate.setLongitude(String.valueOf(point.getLng()));
        return myCoordinate;
    }
}
