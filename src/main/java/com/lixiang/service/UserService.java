package com.lixiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lixiang.pojo.User;

import java.util.Map;

/**
 * @description:
 * @author: 苏铭
 * @date:  2021/10/19
 **/
public interface UserService  extends IService<User> {

        //根据id 禁止用户登录
        boolean banUserLoginName(String loginName);
        boolean insert(Map<String, String> map);

    Object pageSearch(Map<String, String> map);
}
