package com.example.demo.Enums;

public enum UserEnum {
    SUCCESS(0, "操作成功"),
    INSERT_SUCCESS(0, "新增成功"),
    MODIFY_SUCCESS(0, "修改成功"),
    DEL_SUCCESS(0,"刪除成功"),
    ERROR(1, "錯誤"),
    USER_EXISTS(1, "此編號已存在"),
    USER_NOT_EXISTS(1, "此使用者不存在"),
    DEL_FAIL(1,"刪除失敗"),
    MODIFY_FAIL(1, "修改失敗"),
    ;

    private final Integer STATUS;
    private final String ZH;

    UserEnum(Integer STATUS, String ZH) {
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
