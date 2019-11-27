package com.it.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class RowModel extends BaseRowModel {
    @ExcelProperty(index = 0)
    private String id;
    @ExcelProperty(index = 1)
    private String nickName;
    @ExcelProperty(index = 2)
    private String name;
    @ExcelProperty(index = 3)
    private int age;
    @ExcelProperty(index = 4)
    private String address;

    @ExcelProperty(value = "微服务",index = 5)
    private String microService;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getMicroService() {
        return microService;
    }

    public void setMicroService(String microService) {
        this.microService = microService;
    }
}
