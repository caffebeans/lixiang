package com.lixiang;

import com.lixiang.mapper.UserInfoMapper;
import com.lixiang.mapper.UserMapperr;
import com.lixiang.po.User;
import com.lixiang.po.UserInfo;
import com.lixiang.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/10/19
 **/
public class UserTest extends LixiangApplicationTests{

     @Autowired
     UserInfoMapper userInfoMapper;
     @Autowired
     UserMapperr userMapperr;
     @Autowired
    UserService userService;

    @Test
    void log() {

        User user = new User();
        user.setLoginName("MarkerHub");
        userService.login(new User());

    }

    @Test
    void name() {

        User user = new User();
        user.setLoginName("zhang");
        user.setPassword("hello");
        userMapperr.insert(user);

    }

    @Test
    void add() {

        UserInfo info = new UserInfo();

        info.setLoginName("zhang");
       info.setUsername("z");
       userInfoMapper.insert(info);

    }





}
