package com.lixiang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lixiang.mapper.UserMapper;
import com.lixiang.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lixiang.mapper.UserInfoMapper;
import com.lixiang.pojo.UserInfo;
import com.lixiang.service.UserInfoService;
import org.springframework.transaction.annotation.Transactional;

import java.security.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * @description:
 * @author: 苏铭
 * @date:  2021/10/19
 **/
@Service
@Slf4j
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService{

     @Autowired
     UserInfoMapper userInfoMapper;
     @Autowired
    UserMapper userMapper;

     @Override
     @Transactional
     public boolean add(Map<String, String> map) {
        return true;
    }
}
