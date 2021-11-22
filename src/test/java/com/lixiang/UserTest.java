package com.lixiang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lixiang.mapper.RoleMapper;
import com.lixiang.mapper.UserInfoMapper;
import com.lixiang.mapper.UserMapperr;
import com.lixiang.pojo.User;
import com.lixiang.pojo.UserInfo;
import com.lixiang.vo.ResultCode;
import com.lixiang.vo.ResultVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
