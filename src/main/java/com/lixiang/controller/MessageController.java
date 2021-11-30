package com.lixiang.controller;

import com.lixiang.po.PhoneCode;
import com.lixiang.service.PhoneMessageService;
import com.lixiang.util.VerityCodeUtil;
import com.lixiang.vo.PhoneVerityVo;
import com.lixiang.vo.ResultVo;
import io.swagger.annotations.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Random;

/**
 * @description: 阿里云短信接口
 * @author: 张亮
 * @date: 2021/11/22
 **/
@RestController
@RequestMapping("/message")
@Api(tags = "信息发送接口")
@Data
@Slf4j
public class MessageController {

    @Autowired
    PhoneMessageService phoneMessageService;
    @Resource
    RedisTemplate<String, String> redisUtil;
    @Autowired
    PhoneCode phoneCode;


    @ApiOperation("发送手机验证码")
    @PostMapping("/phoneNumber/send")
    @ApiParam(name = "phoneNum", value = "手机号码", required = true)
    @ApiResponses(value = {@ApiResponse(code = 10001, message = "手机号码不存在"),
            @ApiResponse(code = 10001, message = "手机号码不存在")
    }
    )
    public ResultVo send(@RequestBody String phoneNum) {

        log.info("发送短信接口被调用了");
        String s1 = VerityCodeUtil.generatePhoneCode(6);

        // 1.先发送， 可果发送成果， 要知道是否发送成功

        return ResultVo.SUCCESS();
    }


    @ApiOperation("手机号码验证")
    public ResultVo codeVerity(@RequestBody PhoneVerityVo phoneVerityVo) {
        try{

        }catch(Exception e){

        }
        log.info("手机号码认证");
        return ResultVo.SUCCESS();

    }


}
