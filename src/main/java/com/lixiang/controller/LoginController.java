package com.lixiang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lixiang.mapper.UserMapperr;
import com.lixiang.pojo.User;
import com.lixiang.vo.ResultCode;
import com.lixiang.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @description:
 * @author: 苏铭
 * @date: 2021/10/19
 **/
@RestController
@Slf4j
@Api(tags="登陆管理")
public class LoginController {

     @Autowired
     UserMapperr userMapper;

     @PostMapping("/login")
     @ApiOperation("登陆接口")
     public ResultVo login(@RequestBody Map<String,String> map){

        map.keySet().forEach(System.out::println);

         log.info("用户进行登陆~~~~");
         map.keySet().forEach(System.out::println);
         User user = new User();
         user.setLoginName(map.get("username"));
         user.setPassword(map.get("password"));

         try{
             user = userMapper.selectOne(new QueryWrapper<>(user));
         }catch(Exception e){
              return ResultVo.ERROR();
         }

         return user==null?ResultVo.ERROR(ResultCode.USER_NO_EXIST):ResultVo.SUCCESS(user.getLoginName());



     }

}
