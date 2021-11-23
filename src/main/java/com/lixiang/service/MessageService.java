package com.lixiang.service;

/**
 * @description:  调用阿里短信的接口，作为登陆认证
 * @author: 张亮
 * @date: 2021/11/22
 **/
public interface MessageService {

      String sendMessage(String phone,String code);
      String verifyCode(String phone,String code);

}
