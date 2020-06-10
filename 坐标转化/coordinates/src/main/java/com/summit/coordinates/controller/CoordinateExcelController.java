package com.summit.coordinates.controller;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.summit.coordinates.config.ExcelListener;
import com.summit.coordinates.entity.MyCoordinate;
import com.summit.coordinates.entity.MyCoordinate2;
import com.summit.coordinates.util.CoordinateFormatUtil;
import com.summit.coordinates.util.MyUitls;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by liusj on 2019/5/24
 */
@Slf4j
@Api(tags = "Excel批量转换坐标")
@RestController("/batchs")
public class CoordinateExcelController {

    private static final String REGEX = "^\\d+" + "°" + "\\d+′?'?" + "\\d*\\.?\\d*\"?〃?″?"; // 度分秒
    private static final String REGEX2 = "^\\d+" + "°" + "\\d*\\.?\\d*′?'?$";  // 度分
    private static final String REGEX3 = "^\\d+" + "(\\." + "\\d+)?$";  // 小数点

    private static final String TRUE = "true";
    private static final String FALSE = "false";
    @Autowired
    private CacheManager cacheManager;

    @ApiOperation(value = "转换后的坐标Excel导出",
            notes = "Excel批量导入坐标后，复制该请求链接浏览器访问下载Excel(转换后的坐标)，转换失败Excel会有相应提示")
    @GetMapping("/not-auth/export")
    public void downLoad(HttpServletResponse response) throws Exception {
        Cache cache = cacheManager.getCache("file");
        Cache.ValueWrapper cacheValue = cache.get("result");
        if (cacheValue != null) {
            List<MyCoordinate> result = (List<MyCoordinate>) cacheValue.get();
            //  写入excel
            response.setCharacterEncoding("UTF-8");
            String name = URLEncoder.encode("转换后的Gcj02坐标.xlsx", "UTF-8");
            response.setContentType("application/x-msdownload");
            response.addHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + name);
            try (OutputStream out = response.getOutputStream()) {
                ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
                Sheet sheet1 = new Sheet(1, 0, MyCoordinate.class);
                sheet1.setSheetName("转换后的Gcj02坐标");
                writer.write(result, sheet1);
                writer.finish();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        cache.clear();
    }

    @ApiOperation(value = "Excel批量导入坐标，WGS-84坐标转GCJ-02坐标",
            notes = "经纬度支持度（108.9017200000）、度分（108°53）或度分秒三种格式导入（108°53'49.64\"），注意°、'、\"都要用英文格式，且与数字之间无空格。")
    @PostMapping("/not-auth/import")
    public void importExcel(@RequestParam("file") MultipartFile file) throws Exception {
        // 清缓存
        Cache cache = cacheManager.getCache("file");
        cache.clear();
        // 数据处理
        List<MyCoordinate> result = convertCoordinate(file);
        //  写入緩存
        cache.put("result", result);
    }

    @ApiOperation("Excel导入模板下载")
    @GetMapping("/not-auth/template")
    public void template(HttpServletResponse response) throws Exception {
        List<MyCoordinate> result = new ArrayList<>();
        response.setCharacterEncoding("UTF-8");
        String name = URLEncoder.encode("坐标转换模板.xlsx", "UTF-8");
        response.setContentType("application/x-msdownload");
        response.addHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + name);
        try (OutputStream out = response.getOutputStream()) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0, MyCoordinate2.class);

            sheet1.setSheetName("坐标转换模板");
            writer.write(result, sheet1);
            writer.finish();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 1, 读取Excel中的坐标数据
     * 2. 遍历坐标数据，
     * a. 坐标数据格式转换,度分秒、度分转度
     * b. 坐标数据经纬度格式转换，WGS84转GCJ02
     */
    private List<MyCoordinate> convertCoordinate(@RequestParam("file") MultipartFile file) throws IOException {

        // 读取Excel中的坐标数据
        ExcelListener listener = new ExcelListener();
        ExcelReader excelReader = new ExcelReader(file.getInputStream(), ExcelTypeEnum.XLSX, null, listener);
        excelReader.read(new Sheet(1, 1, MyCoordinate.class));

        List<MyCoordinate> datas = listener.getDatas();

        Pattern pattern = Pattern.compile(REGEX);
        Pattern pattern2 = Pattern.compile(REGEX2);
        Pattern pattern3 = Pattern.compile(REGEX3);

        List<MyCoordinate> result = new ArrayList<>();
        String lat;
        String lng;
        // 遍历坐标数据
        for (MyCoordinate myCoordinate : datas) {

            lat = myCoordinate.getLatitude();
            lng = myCoordinate.getLongitude();

            if (StringUtils.isEmpty(lat) || StringUtils.isEmpty(lng) || StringUtils.isEmpty(lat.trim()) || StringUtils.isEmpty(lng.trim())) {
                myCoordinate.setRemark("数据不能为空");
                myCoordinate.setIsSucceeded(FALSE);
                result.add(myCoordinate);
                continue;
            }

            lat = lat.trim();
            lng = lng.trim();

            if (pattern.matcher(lat).find() && pattern2.matcher(lng).find()) {
                myCoordinate.setLongitude(CoordinateFormatUtil.DmsTurnDD(lat));
                myCoordinate.setLatitude(CoordinateFormatUtil.DmsTurnDD(lng));
                myCoordinate.setIsSucceeded(TRUE);
                result.add(MyUitls.wgs84ToGcj02Copy(myCoordinate));
                continue;
            }
            if (pattern2.matcher(lat).find() && pattern2.matcher(lng).find()) {
                myCoordinate.setLongitude(CoordinateFormatUtil.DmTurnDD(lat));
                myCoordinate.setLatitude(CoordinateFormatUtil.DmTurnDD(lng));
                myCoordinate.setIsSucceeded(TRUE);
                result.add(MyUitls.wgs84ToGcj02Copy(myCoordinate));
                continue;
            }
            if (pattern3.matcher(lat).find() && pattern3.matcher(lng).find()) {
                myCoordinate.setIsSucceeded(TRUE);
                result.add(MyUitls.wgs84ToGcj02Copy(myCoordinate));
                continue;
            }
            myCoordinate.setIsSucceeded(FALSE);
            myCoordinate.setRemark("数据格式有误");
            result.add(myCoordinate);
        }
        return result;
    }
}
