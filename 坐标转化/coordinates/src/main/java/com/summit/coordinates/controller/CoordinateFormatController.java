package com.summit.coordinates.controller;

import com.summit.coordinates.util.CoordinateFormatUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusj on 2020/6/8
 * <p>
 * 坐标格式转换Controller.
 */
@Api(tags = "坐标格式转换Controller")
@RestController("/formats")
public class CoordinateFormatController {

    @ApiOperation("度分秒格式坐标转度度格式坐标，example：108°13′21″= 108.2225")
    @ApiParam(name = "dms", value = "待转换坐标", required = true)
    @GetMapping("/dmsTurnDD")
    public String dmsTurnDD(@RequestParam String dms) {
        return CoordinateFormatUtils.DmsTurnDD(dms);
    }

    @ApiOperation("度分格式坐标转度度格式坐标，example：112°30.4128 = 112.50688")
    @ApiParam(name = "dms", value = "待转换坐标", required = true)
    @GetMapping("/dmTurnDD")
    public String dmTurnDD(@RequestParam String dm) {
        return CoordinateFormatUtils.DmTurnDD(dm);
    }

}
