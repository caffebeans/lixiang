package com.lixiang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lixiang.mapper.UserMapper;
import com.lixiang.pojo.User;
import com.lixiang.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @description:
 * @author: 苏铭
 * @date: 2021/10/19
 **/
@RestController
@Slf4j
public class LoginController {

     @Autowired
     UserMapper userMapper;

     @PostMapping("/login")
     public ResultVo login(@RequestParam Map<String,String> map){

        map.keySet().forEach(System.out::println);

         log.info("用户进行登陆~~~~");
         map.keySet().forEach(System.out::println);
         User user = new User();
         user.setLoginName(map.get("username"));
         user.setPassword(map.get("password"));
         user.setStatus(1);
         try{
             User ans = userMapper.selectOne(new QueryWrapper<>(user));
             System.out.println(ans);

         }catch(Exception e){

         }

         return ResultVo.SUCCESS();

     }

}
