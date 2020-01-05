package org.example.enums;

public enum ProgressStatusEnum {

    ERROR("error"),
    FINISH("finish"),
    EXCUTING("excuting");

    String name;

    ProgressStatusEnum(String name) {
        this.name=name;
    }
}
