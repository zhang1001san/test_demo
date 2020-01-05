package org.example.vo;

import org.example.enums.CopyTaskOperateEnum;

import java.util.List;

public class TemplateVo {
    private String tableName;
    private CopyTaskOperateEnum operate;


    private List<String> deleteKeyList;
    private List<String> colunmList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public CopyTaskOperateEnum getOperate() {
        return operate;
    }

    public void setOperate(CopyTaskOperateEnum operate) {
        this.operate = operate;
    }

    public List<String> getColunmList() {
        return colunmList;
    }

    public void setColunmList(List<String> colunmList) {
        this.colunmList = colunmList;
    }

    public List<String> getDeleteKeyList() {
        return deleteKeyList;
    }

    public void setDeleteKeyList(List<String> deleteKeyList) {
        this.deleteKeyList = deleteKeyList;
    }
}
