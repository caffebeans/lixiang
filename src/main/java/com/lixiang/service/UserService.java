package com.lixiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lixiang.po.User;
import com.lixiang.po.UserInfo;
import com.lixiang.vo.UserAndRoleVo;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/10/19
 **/
public interface UserService extends IService<User> {


    User login(User user);

    //根据id 禁止用户登录
    boolean banUserLoginName(String loginName);

    boolean insert(Map<String, String> map);

    Object pageSearch(Map<String, String> map);

    List<UserInfo> searchByUserNameOrID(Map<String, String> map);


    boolean editUserRole(UserAndRoleVo userAndRoleVo);
}
