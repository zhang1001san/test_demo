package org.example.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserMapper {

    List<Map<String, Object>> getList();

    void deleteTask(@Param("tableName") String tableName, @Param("deleteParameterMap") Map<String, String> deleteParameterMap);

    List<Map<String, Object>> getMapList(@Param("tableName") String tableName, @Param("parameterMap") Map<String, String> parameterMap);

    void copyTask(@Param("tableName") String tableName, @Param("selectColumns") Set<String> selectColumns, @Param("insertInfoList") List<Map<String, Object>> insertInfoList);

}
