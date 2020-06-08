package com.summit.coordinates.config;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.summit.coordinates.entity.MyCoordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liusj on 2019/5/27
 * 阿里easyExcel.
 */
public class ExcelListener extends AnalysisEventListener {

    private List<MyCoordinate> datas = new ArrayList<>();

    @Override
    public void invoke(Object obj, AnalysisContext analysisContext) {
        datas.add((MyCoordinate) obj);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public List<MyCoordinate> getDatas() {
        return datas;
    }

    public void setDatas(List<MyCoordinate> datas) {
        this.datas = datas;
    }
}
