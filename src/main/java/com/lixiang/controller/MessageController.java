package com.lixiang.controller;

import com.lixiang.service.MessageService;
import com.lixiang.vo.ResultVo;
import io.swagger.annotations.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.util.annotation.Nullable;
import springfox.documentation.spring.web.json.Json;

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
public class MessageController {

    @Autowired
    MessageService messageService;
    @Resource
    RedisTemplate<String,String> redisUtil;


    @ApiOperation("发送手机验证码")
    @PostMapping("/phoneNumber/send")
    @ApiParam(name = "phoneNum", value = "手机号码",required = true)
    @ApiResponses(value = {@ApiResponse(code = 10001, message = "手机号码不存在"),
            @ApiResponse(code = 10001, message = "手机号码不存在")
       }
    )
    public ResultVo send(@RequestBody @Nullable String phoneNum){
        /**
         * @des： 限定信息的发送次数，有设置短信的有效期，
         * 短信的随机数给出
         */
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            buffer.append(random.nextInt(9));
        }
        // 1.先发送， 可果发送成果， 要知道是否发送成功
        String s = messageService.sendMessage(phoneNum, buffer.toString());
        // 2.发送成功后，将值返回
        ValueOperations valueOperations = redisUtil.opsForValue();
        valueOperations.set(phoneNum,buffer.toString());

        return ResultVo.SUCCESS(s);
    }





}
