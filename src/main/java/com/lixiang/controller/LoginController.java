package com.lixiang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lixiang.mapper.UserMapperr;
import com.lixiang.po.User;
import com.lixiang.vo.ResultCode;
import com.lixiang.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @description: 用户登陆接口的逻辑实现，由于当前只进行用户与角色的关系，没有角色与权限的关系，因此当前的用户登陆是不完备的
 * @author: 张亮
 * @date: 2021/10/19
 **/
@RestController
@Slf4j
@Api(tags = "登陆管理")
public class LoginController {

    @Autowired
    UserMapperr userMapper;
    @Autowired
    RedisTemplate<String, String> redisTemplate;


    @PostMapping("/login")
    @ApiOperation(value = "登陆接口", notes = "" +
            "用户在进行登陆时，要做严格的登陆限制" +
            "1. 一分钟内用户错误两次，需要手机验证" +
            "2. 如果用户没有添加手机号码，则需要发送邮件" +
            "3. 认证规则不是一成不变的，最好后期制定完整的规则进行配置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName", value = "用户名", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "用户密码", dataType = "string", paramType = "query", required = true)})

    /** 详细的过程如下：
     *    1. 用户登陆时，需要先去缓存中查找用户有没有正在进行登陆，防止同一用户频繁调用后台接口
     *    2. 记录用户错误的次数，一个时间节点内错误次数不能太多
     *
     */
    public ResultVo login(@RequestBody User user) {


        ResultVo resultVo = null;
        log.info("用户" + user.toString() + "在进行登陆");
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());

        try {
            SecurityUtils.getSubject().login(token);

        } catch (AuthenticationException e) {
            if (e instanceof UnknownAccountException) {
                return ResultVo.ERROR(ResultCode.USER_NO_EXIST);
            } else if (e instanceof LockedAccountException) {
                return ResultVo.ERROR(ResultCode.USER_NO_EXIST);
            } else if (e instanceof IncorrectCredentialsException) {
                return ResultVo.ERROR(ResultCode.USER_NO_EXIST);
            } else {
                return ResultVo.ERROR(ResultCode.USER_NO_EXIST);
            }

        }
        return ResultVo.SUCCESS();
        //
        // try{
        //     user = userMapper.selectOne(new QueryWrapper<>(user));
        // }catch(Exception e){
        //      return ResultVo.ERROR();
        // }

        // return user==null?ResultVo.ERROR(ResultCode.USER_NO_EXIST):ResultVo.SUCCESS(user.getLoginName());

    }

}
