package com.it.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class RowModel extends BaseRowModel {
    @ExcelProperty(index = 0)
    private String cid;

    @ExcelProperty(index = 1)
    private String path;

    @ExcelProperty(index = 2)
    private String name;

    @ExcelProperty(index = 3)
    private String time;

    @ExcelProperty(index = 4)
    private String filePath;

    @ExcelProperty(value = "微服务", index = 5)
    private String microService;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getMicroService() {
        return microService;
    }

    public void setMicroService(String microService) {
        this.microService = microService;
    }
}
