package com.lixiang.config;

import com.lixiang.vo.ResultVo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/11/24
 **/
@RestController
@RequestMapping("/rabbit")
public class RabbitTestController {

    @Autowired
    RabbitTemplate template;

    @GetMapping("/send")
    public ResultVo sendMessage(String message) {

        for (int i = 0; i <1000 ; i++) {

            template.convertAndSend("phoneCode","hello"+i);
        }
        return ResultVo.SUCCESS();
    }


}
