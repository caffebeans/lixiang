package com.lixiang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lixiang.mapper.UserMapper;
import com.lixiang.pojo.Role;
import com.lixiang.pojo.User;
import com.lixiang.pojo.UserInfo;
import com.lixiang.service.UserInfoService;
import com.lixiang.service.UserService;
import com.lixiang.vo.ResultCode;
import com.lixiang.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 苏铭
 * @date: 2021/10/20
 **/
@RestController
@Slf4j
@RequestMapping("/v1/user")
public class UserController {

      @Autowired
      UserInfoService userInfoServiceService;
      @Autowired
      UserService userService;
      @Autowired
      UserMapper userMapper;

    @GetMapping("/")
    public ResultVo list(@RequestParam Map<String,String> map){

        Object o = userService.pageSearch(map);
        return ResultVo.SUCCESS(o);
    }

    @PostMapping("/add")
    public ResultVo post(@RequestBody Map<String,String> map){
        log.info("添加用户");
        boolean res=false;
        res=userService.insert(map);
        return res?ResultVo.SUCCESS():ResultVo.ERROR(ResultCode.ROLE_UPDATE_ERROR);
    }


    @RequestMapping("/update")
    public ResultVo update(@RequestBody UserInfo userInfo){
        log.info("更新用户");
        boolean res;
        try{
            res = userInfoServiceService.updateById(userInfo);
        }catch(Exception e) {
            return ResultVo.ERROR();
        }
        return res?ResultVo.SUCCESS():ResultVo.ERROR(ResultCode.ROLE_UPDATE_ERROR);
    }

    @GetMapping("/banUserById")
    @Transactional
    public ResultVo banUserById(@RequestParam("login_name") String loginName){

        boolean res=userService.banUserLoginName(loginName);

        return res?ResultVo.SUCCESS():ResultVo.ERROR(ResultCode.ROLE_DEL_ERROR);
    }




}
