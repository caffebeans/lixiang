package com.lixiang.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/10/19
 **/
@Getter
@ApiModel("全局状态")
public enum ResultCode {

    SUCCESS(200, "请求成功"),
    ERROR(500, "服务器发生错误"),
    ArgumentType(600,"参数类型不匹配"),
    USER_NO_EXIST(1000, "用户不存"),
    USER_PASSWORD_ERROR(1001, "密码错误"),
    USER_NAMEORPASSWORD_ERROR(1002, "用户名或者密码错误"),
    ROLE_UPDATE_ERROR(2001, "角色更新错误"),
    ROLE_DEL_ERROR(2001, "角色删除错误");


    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code=code;
        this.msg=msg;
    };




}
