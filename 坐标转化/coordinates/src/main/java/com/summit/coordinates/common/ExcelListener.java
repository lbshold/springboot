package com.summit.coordinates.common;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liusj on 2019/5/27
 * 阿里easyExcel.
 */
public class ExcelListener extends AnalysisEventListener {

    private List<MyObject> datas = new ArrayList<>();

    @Override
    public void invoke(Object obj, AnalysisContext analysisContext) {
        datas.add((MyObject) obj);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public List<MyObject> getDatas() {
        return datas;
    }

    public void setDatas(List<MyObject> datas) {
        this.datas = datas;
    }
}
