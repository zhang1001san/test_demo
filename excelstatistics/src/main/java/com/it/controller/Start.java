package com.it.controller;

import com.it.model.CountModel;
import com.it.model.RowModel;
import com.it.util.ExcelUtil;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Start {
    private static String microServices = "basicinfo,cfg,lld,other,all";
    private static String other = "other";
    private static String all = "all";
    private static Map<String, Integer> microServiceMap = null;
    private static List<String> microServiceList = null;
    private static Properties prop = null;

    public static void main(String[] args) throws IOException {
        onStart();
        writeExcelTest();
        writeCount();
    }


    public static void onStart() throws IOException {
        String filePath = System.getProperty("user.dir");
        System.out.println(filePath);
        File file = new File(filePath, "config.properties");
        prop = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        prop.load(in);
        System.out.println(prop);
        microServices = prop.getProperty("microServices");
        microServiceMap = new LinkedHashMap<>();
        microServiceList = Arrays.asList(Start.microServices.split(","));
        for (String micro : microServiceList) {
            microServiceMap.put(micro, 0);
        }
    }


    public static void writeExcelTest() throws IOException {
        String inputFile = prop.getProperty("srcFile");
        String outputFile = prop.getProperty("destFile");
        File file = new File(outputFile);
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile))
        ) {
            List<RowModel> baseRowModels = ExcelUtil.readExcel(bis, RowModel.class);
            String defectStatus = prop.getProperty("defectStatus");
            if (defectStatus != null) {
                List<String> defectStatusList = Arrays.asList(defectStatus.split(","));
                baseRowModels = baseRowModels.stream().filter(rowModel -> {
                    return defectStatusList.contains(rowModel.getDefectStatus());
                }).collect(Collectors.toList());
            }


            boolean isFind = false;
            for (RowModel baseRowModel : baseRowModels) {
                isFind = false;
                for (String micro : microServiceList) {
                    if (baseRowModel.getFile().contains(getMicroName(micro))) {
                        isFind = true;
                        count(micro);

                        baseRowModel.setMicroService(micro);
                        break;
                    }
                }
                // 没找到标记为other
                if (!isFind) {
                    count(other);
                    baseRowModel.setMicroService(other);
                }
                count(all);
            }
            ExcelUtil.writeExcel(file, baseRowModels);
        }
    }

    public static String getMicroName(String micro){
        String microName=micro;
        String prefixName = prop.getProperty("prefixName");
        if (prefixName!=null){
            microName=prefixName+micro;
        }
        return microName;
    }

    /**
     * 统计
     */
    public static void writeCount() throws FileNotFoundException {
        String outputFile = prop.getProperty("countFile");
        File file = new File(outputFile);
        ArrayList<CountModel> countModels = new ArrayList<>();
        CountModel countModel = null;
        for (Map.Entry<String, Integer> countEntry : microServiceMap.entrySet()) {
            countModel = new CountModel(countEntry.getKey(), countEntry.getValue());
            countModels.add(countModel);
        }
        ExcelUtil.writeExcel(file, countModels);
    }

    public static void count(String micro) {
        Integer count = microServiceMap.get(micro);
        count++;
        microServiceMap.put(micro, count);
    }
}
