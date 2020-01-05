package org.example.business;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.UserMapper;
import org.example.enums.CopyTaskOperateEnum;
import org.example.enums.ProgressStatusEnum;
import org.example.util.CopyTaskUtil;
import org.example.util.SqlUtil;
import org.example.vo.CopyTaskProgressVo;
import org.example.vo.TemplateVo;

import java.util.*;


public class CopyTaskBusiness {

    public   void executeXmlTask(List<TemplateVo> templateList,String progressKey,
              Map<String, CopyTaskProgressVo> progressMap,Map<String,Map<String,String>> parameterMap){
        // 校验
        int allTaskSize=templateList.size();
        int excuteTaskNum=0;
        try {
            for( TemplateVo templateVo:templateList){
                switch (templateVo.getOperate()){
                    case COPY:
                                break;
                    case DELETE:
                        break;
                    case INSERT:
                    default:
                        break;
                }
                excuteTaskNum++;
                // 更新进度
                if(excuteTaskNum<allTaskSize){
                    CopyTaskUtil.updateProgress(ProgressStatusEnum.EXCUTING,progressKey,excuteTaskNum,allTaskSize,progressMap);
                }else{
                    CopyTaskUtil.updateProgress(ProgressStatusEnum.FINISH,progressKey,excuteTaskNum,allTaskSize,progressMap);
                }

            }
        }catch (Exception e){
            // 记录日志
            // 更新进度
            CopyTaskUtil.updateProgress(ProgressStatusEnum.ERROR,progressKey,allTaskSize,allTaskSize,progressMap);
        }

    }


    private void startCopy(TemplateVo templateVo,Map<String,Map<String,String>> parameterMap){
        SqlSession sqlSession = SqlUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, String> queryParameterMap = CopyTaskUtil.createOldValueParameterMap(templateVo.getColunmList(), parameterMap);

        List<Map<String, Object>> mapList = mapper.getMapList(templateVo.getTableName(), queryParameterMap);

        Map<String, String> newValueParameterMap = CopyTaskUtil.createNewValueParameterMap(templateVo.getColunmList(), parameterMap);

        for (Map<String, Object> map:mapList){
            // 修改为新内容
            for (String column:templateVo.getColunmList()){
                map.put(column,newValueParameterMap.get(column));
            }


            // 删除key
            CopyTaskUtil.deleteMap(map,templateVo.getDeleteKeyList());
        }
        Set<String> selectColumns = mapList.get(0).keySet();
        mapper.copyTask(templateVo.getTableName(),selectColumns,mapList);

//        Map<String, Object> xxMap = mapList.get(1);
//
//        for (Map.Entry<String, Object> entries:xxMap.entrySet()){
//            System.out.println(entries.getValue().getClass());
//        }


        sqlSession.commit();
        sqlSession.close();
    }

    public static void main(String[] args) {
        TemplateVo templateVo = new TemplateVo();
        templateVo.setTableName("haha");
        templateVo.setOperate(CopyTaskOperateEnum.COPY);
        List<String> columnList=new ArrayList<>();
        columnList.add("sex");
        columnList.add("password");
        HashMap<String, String> sexMap = new HashMap<>();
        sexMap.put("old","m");
        sexMap.put("new","女");
        Map<String, String> passwordMap = new HashMap<>();
        passwordMap.put("old","11");
        passwordMap.put("new","222");
        Map<String,Map<String,String>> parameterMap =new HashMap<>();
        parameterMap.put("sex",sexMap);
        parameterMap.put("password",passwordMap);


        templateVo.setColunmList(columnList);
        List<String> deleteKeyList=new ArrayList<>();
        deleteKeyList.add("id");
        templateVo.setDeleteKeyList(deleteKeyList);
        CopyTaskBusiness taskBusiness = new CopyTaskBusiness();
        taskBusiness.startCopy(templateVo,parameterMap);
    }


}
