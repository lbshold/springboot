package com.summit.coordinates.controller;

import com.summit.coordinates.util.CoordinateConvertUtils;
import com.summit.coordinates.util.CoordinateFormatUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusj on 2020/6/8
 * <p>
 * 坐标其他工具.
 */
@Api(value = "坐标工具Controller", tags = "坐标工具Controller")
@RestController("/others")
public class CoordinateOtherController {

    @ApiOperation(value = "根据两坐标计算两点之间的距离   单位：米")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lng1", value = "经度1", required = true),
            @ApiImplicitParam(name = "lat1", value = "纬度1", required = true),
            @ApiImplicitParam(name = "lng2", value = "经度2", required = true),
            @ApiImplicitParam(name = "lat2", value = "纬度2", required = true)
    })
    @GetMapping("/getDistance")
    public String getDistance(@RequestParam double lng1,
                              @RequestParam double lat1,
                              @RequestParam double lng2,
                              @RequestParam double lat2) {
        return String.format("%.2f", CoordinateFormatUtils.getDistance(lat1, lng1, lat2, lng2));
    }

    @ApiOperation("判断是否在国外")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lng", value = "经度", required = true),
            @ApiImplicitParam(name = "lat", value = "纬度", required = true)
    })
    @GetMapping("/outOfChina")
    public boolean outOfChina(double lng, double lat) {
        return CoordinateConvertUtils.outOfChina(lng, lat);
    }
}
