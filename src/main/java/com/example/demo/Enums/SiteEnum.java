package com.example.demo.Enums;

public enum SiteEnum {
    SUCCESS(0,"操作成功"),
    INSERT_SUCCESS(0, "新增成功"),
    MODIFY_SUCCESS(0, "修改成功"),
    DEL_SUCCESS(0, "刪除成功"),
    FAIL(1,"操作失敗"),
    DEL_FAIL(1, "刪除失敗"),
    SITE_EXISTS(1, "站點已存在"),
    SITE_NOT_EXISTS(1,"站點不存在"),
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
