package com.summit.coordinates.common;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * Created by liusj on 2019/5/27
 * <p>
 * 实体类.
 */
public class MyObject extends BaseRowModel {

    @ExcelProperty(value = "经度(火星坐标)", index = 0)
    private String longitude;
    @ExcelProperty(value = "纬度(火星坐标)", index = 1)
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
