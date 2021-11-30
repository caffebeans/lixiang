package com.lixiang.exception;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/11/26
 **/
public class CodeLengthError extends Exception{

    @Override
    public String getMessage() {
        return "生成验证码长度输入错误";
    }
}
