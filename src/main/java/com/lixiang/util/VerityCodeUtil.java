package com.lixiang.util;

import com.lixiang.exception.CodeLengthError;

import java.util.Random;

/**
 * @description: 用于生成验证码的工具类
 * 默认情况下生成六位， 在此不做业务的扩展
 * @author: 张亮
 * @date: 2021/11/26
 **/
public class VerityCodeUtil {


    /**
     * @param length:生成验证码的长度,范围在4-8之间
     * @return
     */
    public static String generatePhoneCode(int length) {
        StringBuffer code = new StringBuffer();
        try {
            if (length < 4 || length > 8) {
                throw new CodeLengthError();
            }
            Random random = new Random();
            for (int i = 0; i < length; i++) {
                code.append(random.nextInt(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code.toString();
    }
}
