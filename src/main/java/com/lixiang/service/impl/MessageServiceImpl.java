package com.lixiang.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.lixiang.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * @description: 完成短信服务
 * @author: 张亮
 * @date: 2021/11/22
 **/
@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public String sendMessage(String phone, String code) {
        CommonResponse response = null;
        String accesskeyId = "LTAI5tBvQqoJ8kP13xquAKn6";
        String accessKeySecret="lsH898eIIkzMN6cYzVRgcNptBBoyGF";
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",accesskeyId , accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers",phone );
        request.putQueryParameter("SignName", "校园防疫");
        request.putQueryParameter("TemplateCode", "SMS_175581900");
        request.putQueryParameter("TemplateParam", "{code:"+code+"}");

        try {
             response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }

        return response.getHttpResponse().toString();
    }

    @Override
    public String verifyCode(String phone, String code) {
        return null;
    }

}
