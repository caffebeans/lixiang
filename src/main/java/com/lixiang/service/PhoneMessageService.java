package com.lixiang.service;

import com.lixiang.vo.PhoneVerityVo;

/**
 * @description:  顶级消息的接口，它的子类包括
 *
 * @author: 张亮
 * @date: 2021/11/22
 **/
public interface PhoneMessageService {

      String sendMessage(String phone,String code);
      boolean verifyCode(PhoneVerityVo phoneVerityVo);

}
