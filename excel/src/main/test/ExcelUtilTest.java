import com.alibaba.excel.metadata.BaseRowModel;
import com.it.model.CountModel;
import com.it.model.RowModel;
import com.it.util.ExcelUtil;


import java.io.*;
import java.util.*;

public class ExcelUtilTest {
    private static String microServices = "basicinfo,cfg,lld,other,all";
    private static String other = "other";
    private static String all = "all";
    private static Map<String, Integer> microServiceMap = null;
    private  static List<String> microServiceList = null;

    public static void main(String[] args) throws IOException {
        onStart();
        writeExcelTest();
        writeCount();
    }

    public static void onStart() {
        microServiceMap = new LinkedHashMap<>();
        microServiceList = Arrays.asList(microServices.split(","));
        for (String micro : microServiceList) {
            microServiceMap.put(micro, 0);
        }
    }


    public static void readExcel() throws IOException {
        String file = "D:\\xxxx系统数据库.xlsx";
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            List<BaseRowModel> baseRowModels = ExcelUtil.readExcel(bis, RowModel.class);
            baseRowModels.stream().forEach(System.out::println);
        }
    }


    public static void writeExcelTest() throws IOException {
        String inputFile = "D:\\xxxx系统数据库.xlsx";
        String outputFile = "D:\\xxxx系统数据库22.xlsx";
        File file = new File(outputFile);
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile))
        ) {
            List<RowModel> baseRowModels = ExcelUtil.readExcel(bis, RowModel.class);
            boolean isFind = false;
            for (RowModel baseRowModel : baseRowModels) {
                isFind = false;
                for (String micro : microServiceList) {
                    if (baseRowModel.getAddress().contains(micro)) {
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

    /**
     * 统计
     */
    public static void writeCount() throws FileNotFoundException {
        String outputFile = "D:\\xxxx系统数据库count.xlsx";
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
