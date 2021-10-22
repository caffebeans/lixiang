package com.lixiang.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lixiang.mapper.UserInfoMapper;
import com.lixiang.mapper.UserRoleMapper;
import com.lixiang.pojo.Role;
import com.lixiang.pojo.UserInfo;
import com.lixiang.pojo.UserRole;
import com.lixiang.service.UserRoleService;
import com.lixiang.vo.ResultVo;
import com.lixiang.vo.UserAndRoleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lixiang.mapper.UserMapper;
import com.lixiang.pojo.User;
import com.lixiang.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 苏铭
 * @date: 2021/10/19
 **/

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public boolean banUserLoginName(String loginName) {

        log.info("禁用用户");
        User user = new User();
        UserInfo userInfo = new UserInfo();
        user.setStatus(0);
        userInfo.setStatus(0);

        boolean res = false;
        try {
            if (loginName != null) {
                userMapper.update(user, new QueryWrapper<User>()
                        .eq("login_name", loginName));
                userInfoMapper.update(userInfo, new QueryWrapper<UserInfo>()
                        .eq("login_name", loginName));
            }
        } catch (Exception e) {
            //日志处理
            log.info("禁止用户失败");
            return false;
        }

        return true;
    }

    @Override
    @Transactional
    public boolean insert(Map<String, String> map) {
        map.keySet().forEach(x -> {
            log.info(x);
            log.info(map.get(x));
        });
        int insertUser;
        int insertUserInfo;
        User user = new User();
        UserInfo userInfo = new UserInfo();
        user.setLoginName(map.get("loginName"));
        user.setPassword(map.get("password"));
        userInfo.setLoginName(map.get("loginName"));
        userInfo.setUserId(Long.valueOf(map.get("idCard")));
        userInfo.setIdCard(map.get("idCard"));
        userInfo.setCreated(new Date());
        userInfo.setUsername(map.get("username"));
        userInfo.setAddress(map.get("address"));
        userInfo.setPhone(map.get("phone"));
        userInfo.setEdited(new java.sql.Date(new Date().getTime()));
        userInfo.setGender(Integer.valueOf(map.get("gender")));
        userInfo.setStatus(1);

        insertUserInfo = userInfoMapper.insert(userInfo);
        insertUser = userMapper.insert(user);

        return insertUser == 1 && insertUserInfo == 1 ? true : false;
    }

    @Override
    public Object pageSearch(Map<String, String> map) {

        int pagesize = Integer.valueOf(map.get("currentPageSize"));
        int pagesNumber = Integer.valueOf(map.get("page"));



        Page<UserInfo> page = new Page<> (pagesNumber,pagesize);

        page=userInfoMapper.selectPage(page, null );
        return page;

    }

    /**
     *
     * @param map(传递过来的可能是用户名或者idcar)
     * @return
     */
    @Override
    public List<UserInfo> searchByUserNameOrID(Map<String, String> map) {
        log.info("根据用户名或者id进行查询");
        map.keySet().forEach(System.out::println);

        UserInfo userInfo = new UserInfo();
        UserInfo one;
        if (map.containsKey("userName")&&map.get("userName").trim()!="") userInfo.setUsername(map.get("userName"));
        if (map.containsKey("idCard")&&map.get("idCard").trim()!="") userInfo.setIdCard(map.get("idCard"));

        List<UserInfo> list=null;

        try{
            list = userInfoMapper.selectList(new QueryWrapper<>(userInfo));
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    @Transactional
    public boolean editUserRole(UserAndRoleVo userAndRoleVo) {

        UserInfo user = userAndRoleVo.getUser();
        List<Role> roles = userAndRoleVo.getRoles();

        try{
            roles.stream().forEach(x->{
                System.out.println("****************************************");
                Long id = x.getId();
                UserRole userRole = new UserRole();
                userRole.setRoleId(id);
                userRole.setUserId(user.getId());
                userRoleMapper.insert(userRole);
            });
        }catch(Exception e){
                e.printStackTrace();
        }


        return false;
    }
}
