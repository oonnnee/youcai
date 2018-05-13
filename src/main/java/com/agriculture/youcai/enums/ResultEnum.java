package com.agriculture.youcai.enums;

import lombok.Getter;

@Getter
public enum  ResultEnum {

    MANAGE_GUEST_SAVE_ERROR(1, "新增客户，失败"),
    MANAGE_GUEST_UPDATE_NULL_ID(2, "更新客户，客户id为空"),
    MANAGE_GUEST_UPDATE_NOT_EXIST(3, "更新客户，客户不存在"),
    MANAGE_GUEST_UPDATE_ERROR(4, "更新客户，失败"),
    MANAGE_GUEST_DELETE_NULL_ID(5, "删除客户，客户id为空"),
    MANAGE_GUEST_FIND_ONE_NULL_ID(6, "查询单个客户，客户id为空"),
    MANAGE_GUEST_FIND_ONE_NOT_EXIST(7, "查询单个客户，客户不存在"),
    MANAGE_GUEST_LIST_PARAM_ERROR(8, "查询客户列表，参数错误"),

    MANAGE_CATEGORY_FIND_ONE_NULL_CODE(9, "查询单个产品类别，产品类别编码为空"),
    MANAGE_CATEGORY_FIND_ONE_NOT_EXIST(10, "查询产品类别列表，产品类别不存在");


    private Integer code;

    private String msg;

    ResultEnum() { }

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
