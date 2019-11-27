package com.it;

import com.alibaba.excel.metadata.BaseRowModel;
import com.it.model.CountModel;
import com.it.model.RowModel;
import com.it.util.ExcelUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;

public class ExcelUtilTest {
    private String microServices="basicinfo,cfg,lld,other";
    private String other="other";
    private Map<String,Integer> microServiceMap=null;
    private List<String> microServiceList=null;
    @Before
    public void onStart(){
        microServiceMap=new LinkedHashMap<>();
        microServiceList=Arrays.asList(microServices.split(","));
        for (String micro : microServiceList) {
            microServiceMap.put(micro,0);
        }
    }


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
            boolean isFind=false;
            for (RowModel baseRowModel : baseRowModels) {
                isFind=false;
                for (String micro : microServiceList) {
                    if (baseRowModel.getAddress().contains(micro)){
                        isFind=true;
                        count(micro);
                        baseRowModel.setMicroService(micro);
                        break;
                    }
                }
                // 没找到标记为other
                if (!isFind){
                    count(other);
                    baseRowModel.setMicroService(other);
                }
            }
            ExcelUtil.writeExcel(file,baseRowModels);
        }
    }

    /**
     * 统计
     */
    @After
    public void writeCount() throws FileNotFoundException {
        String outputFile="D:\\xxxx系统数据库count.xlsx";
        File file = new File(outputFile);
        ArrayList<CountModel> countModels = new ArrayList<>();
        CountModel countModel=null;
        for (Map.Entry<String, Integer> countEntry:microServiceMap.entrySet()){
            countModel=new CountModel(countEntry.getKey(),countEntry.getValue());
            countModels.add(countModel);
        }
        ExcelUtil.writeExcel(file,countModels);
    }

    public void count(String micro){
        Integer count = microServiceMap.get(micro);
        count++;
        microServiceMap.put(micro,count);
    }
}
