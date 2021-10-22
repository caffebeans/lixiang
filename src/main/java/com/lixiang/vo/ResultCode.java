package com.lixiang.vo;

import lombok.Data;

/**
 * @description:
 * @author: 苏铭
 * @date: 2021/10/19
 **/

public enum ResultCode {

    SUCCESS(200, "请求成功"),
    ERROR(500, "服务器发生错误"),
    USER_PASSWORD_ERROR(1000, "密码错误"),
    USER_NO_EXIST(1001, "用户不存"),
    ROLE_UPDATE_ERROR(2001, "角色更新错误"),
    ROLE_DEL_ERROR(2001, "角色删除错误");

    private Integer code;
    private String msg;

    ResultCode(int code, String msg) {
    };

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
