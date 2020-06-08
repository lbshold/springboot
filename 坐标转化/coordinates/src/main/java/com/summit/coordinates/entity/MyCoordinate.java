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
public class MyCoordinate extends BaseRowModel {

    @ExcelProperty(value = "经度(Gcj02坐标)", index = 0)
    private String longitude;
    @ExcelProperty(value = "纬度(Gcj02坐标)", index = 1)
    private String latitude;
    @ExcelProperty(value = "是否转换成功", index = 2)
    private boolean isSucceeded = true;
    @ExcelProperty(value = "备注", index = 3)
    private String remark;

    @Override
    public String toString() {
        return "MyObject{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
