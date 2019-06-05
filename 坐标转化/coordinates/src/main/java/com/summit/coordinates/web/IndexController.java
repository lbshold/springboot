package com.summit.coordinates.web;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.google.common.base.Strings;
import com.summit.coordinates.common.ExcelListener;
import com.summit.coordinates.common.MyObject;
import com.summit.coordinates.util.CoordinateConvertUtils;
import com.summit.coordinates.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liusj on 2019/5/24
 */
@Controller
public class IndexController {

    private static final String REGEX = "^\\d+" + "°" + "\\d+" + "′" + "\\d*\\.?\\d*" + "″";
    private static final String REGEX2 = "^\\d+" + "°" + "\\d*\\.?\\d*" + "′";
    private static final String REGEX3 = "^\\d+" + "(\\." + "\\d+)?$";

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 导出excel.
     */
    @GetMapping("/export")
    public void downLoad(HttpServletResponse response) throws Exception {
        Cache cache = cacheManager.getCache("file");
        Cache.ValueWrapper cacheValue = cache.get("result");
        if (cacheValue != null) {
            List<MyObject> result = (List<MyObject>) cacheValue.get();
            //  写入excel
            response.setCharacterEncoding("UTF-8");
            String name = URLEncoder.encode("火星坐标.xlsx", "UTF-8");
            response.setContentType("application/x-msdownload");
            response.addHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + name);
            try (OutputStream out = response.getOutputStream()) {
                ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
                Sheet sheet1 = new Sheet(1, 0, MyObject.class);

                sheet1.setSheetName("火星坐标");
                writer.write(result, sheet1);
                writer.finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cache.clear();
    }

    /**
     * excel 导入.
     */
    @PostMapping("/import")
    public void importExcel(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws Exception {
        // 清缓存
        Cache cache = cacheManager.getCache("file");
        cache.clear();

        // 解析每行结果在listener中处理
        ExcelListener listener = new ExcelListener();
        ExcelReader excelReader = new ExcelReader(file.getInputStream(), ExcelTypeEnum.XLSX, null, listener);
        excelReader.read(new Sheet(1, 1, MyObject.class));

        List<MyObject> datas = listener.getDatas();

        // 数据转化
        Pattern pattern = Pattern.compile(REGEX);
        Pattern pattern2 = Pattern.compile(REGEX2);
        Pattern pattern3 = Pattern.compile(REGEX3);
        Matcher matcher = pattern.matcher("116°31′35″");
        System.out.println(matcher.find());

        List<MyObject> result = new ArrayList<>();
        datas.forEach(myObject -> {
            if (!Strings.isNullOrEmpty(myObject.getLatitude())) {
                if (pattern.matcher(myObject.getLatitude().trim()).find() && pattern2.matcher(myObject.getLongitude().trim()).find()) {
                    myObject.setLongitude(CoordinateUtil.DmsTurnDD(myObject.getLongitude()));
                    myObject.setLatitude(CoordinateUtil.DmsTurnDD(myObject.getLatitude()));
                    result.add(CoordinateConvertUtils.wgs84ToGcj02Copy(myObject));
                } else if (pattern2.matcher(myObject.getLatitude().trim()).find() && pattern2.matcher(myObject.getLongitude().trim()).find()) {
                    myObject.setLongitude(CoordinateUtil.DmTurnDD(myObject.getLongitude()));
                    myObject.setLatitude(CoordinateUtil.DmTurnDD(myObject.getLatitude()));
                    result.add(CoordinateConvertUtils.wgs84ToGcj02Copy(myObject));
                } else if (pattern3.matcher(myObject.getLatitude().trim()).find() && pattern3.matcher(myObject.getLongitude().trim()).find()) {
                    result.add(CoordinateConvertUtils.wgs84ToGcj02Copy(myObject));
                } else {
                    System.out.println(myObject);
                    MyObject newObj = new MyObject();
                    newObj.setLatitude("数据格式有误");
                    newObj.setLongitude("数据格式有误");
                    result.add(newObj);
                }
            } else {
                result.add(myObject);
            }
        });
        //  写入緩存
        cache.put("result", result);
//        return "index";
    }
}
