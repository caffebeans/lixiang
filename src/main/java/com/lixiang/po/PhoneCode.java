package com.lixiang.po;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/11/26
 **/

@ConfigurationProperties(prefix = "aliyun.message")
@Data
@Component
public class PhoneCode {
    private String accesskeyId;
    private String accessKeySecret;
    private String regionId;
    private String templateCode;
}
