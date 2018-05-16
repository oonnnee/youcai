package com.agriculture.youcai.enums;

import lombok.Getter;

@Getter
public enum  ResultEnum {

    MANAGE_GUEST_SAVE_ERROR(1, "新增客户，保存时失败"),
    MANAGE_GUEST_UPDATE_ERROR(4, "更新客户，更新时失败"),

    MANAGE_PRODUCT_SAVE_ERROR(11, "新增产品，保存时失败"),
    MANAGE_PRODUCT_UPDATE_ERROR(12, "更新产品，更新时失败");


    private Integer code;

    private String msg;

    ResultEnum() { }

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
