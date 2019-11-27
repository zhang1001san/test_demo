package com.it;

import com.alibaba.excel.metadata.BaseRowModel;
import com.it.model.RowModel;
import com.it.util.ExcelUtil;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtilTest {

    @Test
    public void readExcel() throws IOException {
        String file="D:\\xxxx系统数据库.xlsx";
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            List<BaseRowModel> baseRowModels = ExcelUtil.readExcel(bis, RowModel.class);
            baseRowModels.stream().forEach(System.out::println);
        }
    }

    @Test
    public void writeExcelTest() throws IOException {
        String inputFile="D:\\xxxx系统数据库.xlsx";
        String outputFile="D:\\xxxx系统数据库22.xlsx";
        File file = new File(outputFile);
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile))
            ) {
            List<RowModel> baseRowModels = ExcelUtil.readExcel(bis, RowModel.class);
            baseRowModels.forEach(row->{
                row.setAge(row.getAge()+1);
                row.setNewAddress(row.getAddress()+row.getNickName());
            });
            ExcelUtil.writeExcel(file,baseRowModels);
        }
    }
}
