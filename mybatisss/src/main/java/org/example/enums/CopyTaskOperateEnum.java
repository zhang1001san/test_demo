package org.example.enums;

public enum CopyTaskOperateEnum {
    COPY("copy"),
    DELETE("delete"),
    UPDATE("update"),
    INSERT("insert");

    String name;

    CopyTaskOperateEnum(String name) {
        this.name = name;
    }
}
