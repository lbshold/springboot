package com.summit.coordinates.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * Created by liusj on 2019/5/27
 * <p>
 * 实体类.
 */
@Data
public class MyCoordinate2 extends BaseRowModel {

    @ExcelProperty(value = "经度(wgs84坐标)", index = 0)
    private String longitude;
    @ExcelProperty(value = "纬度(wgs84坐标)", index = 1)
    private String latitude;

    @Override
    public String toString() {
        return "MyObject{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
