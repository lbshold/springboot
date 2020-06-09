package com.summit.coordinates.controller;

import com.summit.coordinates.util.CoordinateConvertUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusj on 2020/6/8
 * <p>
 * 坐标转换Controller.
 */
@Api(tags = "坐标转换Controller")
@RestController("/conversions")
public class CoordinateConvertController {

    @ApiOperation(value = "GC-J02 转 BD-09", notes = "火星坐标系(GCJ-02)转百度坐标系(BD-09)")
    @PostMapping("/gcg02ToBd09")
    public CoordinateConvertUtils.Point gcg02ToBd09(@RequestBody CoordinateConvertUtils.Point point) {
        return CoordinateConvertUtils.gcg02ToBd09(point.getLng(), point.getLat());
    }

    @ApiOperation(value = "BD-09 转 GCJ-02", notes = "百度坐标系(BD-09)转火星坐标系(GCJ-02)")
    @PostMapping("/bd09ToGcj02")
    public CoordinateConvertUtils.Point bd09ToGcj02(@RequestBody CoordinateConvertUtils.Point point) {
        return CoordinateConvertUtils.bd09ToGcj02(point.getLng(), point.getLat());
    }

    @ApiOperation(value = "WGS-84 转 GCJ-02", notes = "国际坐标(WGS84)转火星坐标系(GCJ02)")
    @PostMapping("/wgs84ToGcj02")
    public CoordinateConvertUtils.Point wgs84ToGcj02(@RequestBody CoordinateConvertUtils.Point point) {
        return CoordinateConvertUtils.wgs84ToGcj02(point.getLng(), point.getLat());
    }

    @ApiOperation(value = "GC-J02 转 WGS-84", notes = "火星坐标系(GCJ02)转国际坐标(WGS84)")
    @PostMapping("/gcj02ToWgs84")
    public CoordinateConvertUtils.Point gcj02ToWgs84(@RequestBody CoordinateConvertUtils.Point point) {
        return CoordinateConvertUtils.gcj02ToWgs84(point.getLng(), point.getLat());
    }
}
