package com.lixiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lixiang.po.UserInfo;

import java.util.Map;

/**
 * @description:
 * @author: 张亮
 * @date:  2021/10/19
 **/
public interface UserInfoService extends IService<UserInfo> {

        boolean add(Map<String, String> map);
    }
