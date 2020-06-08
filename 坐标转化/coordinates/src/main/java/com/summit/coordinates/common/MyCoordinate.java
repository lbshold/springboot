package com.summit.coordinates.common;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * Created by liusj on 2019/5/27
 * <p>
 * 实体类.
 */
@Data
public class MyCoordinate extends BaseRowModel {

    @ExcelProperty(value = "经度(火星坐标)", index = 0)
    private String longitude;
    @ExcelProperty(value = "纬度(火星坐标)", index = 1)
    private String latitude;
    @ExcelProperty(value = "备注", index = 2)
    private String remark;

    @Override
    public String toString() {
        return "MyObject{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
