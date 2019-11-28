package com.it.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;


public class CountModel extends BaseRowModel {
    @ExcelProperty(value = "微服务",index = 0)
    private String micro;
    @ExcelProperty(value = "小计",index = 1)
    private int count;

    public CountModel() {
    }

    public CountModel(String micro, int count) {
        this.micro = micro;
        this.count = count;
    }

    public String getMicro() {
        return micro;
    }

    public void setMicro(String micro) {
        this.micro = micro;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
