package com.example.demo.Enums;

public enum SiteEnum {
    INSERT_SUCCESS(0, "新增成功"),
    MODIFY_SUCCESS(0, "修改成功"),
    SITE_EXISTS(1, "站點已存在"),
    ;

    private final Integer STATUS;
    private final String ZH;

    SiteEnum(Integer STATUS, String ZH) {
        this.STATUS = STATUS;
        this.ZH = ZH;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public String getZH() {
        return ZH;
    }
}
