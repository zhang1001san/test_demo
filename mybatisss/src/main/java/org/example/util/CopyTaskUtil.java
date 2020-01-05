package org.example.util;

import org.example.constant.PublicIConstant;
import org.example.enums.ProgressStatusEnum;
import org.example.vo.CopyTaskProgressVo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CopyTaskUtil {
    public static void updateProgress(ProgressStatusEnum status, String progressKey, int excuteTaskNum, int allTaskSize, Map<String, CopyTaskProgressVo> progressMap){
        CopyTaskProgressVo taskProgressVo = progressMap.get(progressKey);
        taskProgressVo.setProgressStatus(status);
        // 计算进度
        double progress=1.0*excuteTaskNum/allTaskSize;
        BigDecimal bigDecimal = new BigDecimal(progress).setScale(2, RoundingMode.HALF_UP);
        double newDouble = bigDecimal.doubleValue();
        taskProgressVo.setProgress(newDouble);
    }

    public static String getOldValueByKey(String key,Map<String,Map<String,String>> parameterMap){
        Map<String, String> map = parameterMap.get(key);
        return map.get(PublicIConstant.OLD_KEY);
    }
    public static String getNewValueByKey(String key,Map<String,Map<String,String>> parameterMap){
        Map<String, String> map = parameterMap.get(key);
        return map.get(PublicIConstant.NEW_KEY);
    }

    public static Map<String,String> createOldValueParameterMap(List<String> columnList,Map<String,Map<String,String>> parameterMap){
        Map<String, String> queryParameterMap = new HashMap<>();
        for (String columnName:columnList){
            queryParameterMap.put(columnName,getOldValueByKey(columnName,parameterMap));
        }
        return queryParameterMap;
    }

    public static Map<String,String> createNewValueParameterMap(List<String> columnList,Map<String,Map<String,String>> parameterMap){
        Map<String, String> deleteParameterMap = new HashMap<>();
        for (String columnName:columnList){
            deleteParameterMap.put(columnName,getNewValueByKey(columnName,parameterMap));
        }
        return deleteParameterMap;
    }

    public static void deleteMap(Map<String,Object> map,List<String> deleteKeyList){
        Iterator<String> iter = map.keySet().iterator();
        String key=null;
        while(iter.hasNext()){
            key= iter.next();
            if(deleteKeyList.contains(key)){
                iter.remove();
            }
        }
    }
}
