package com.lixiang.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 手机验证码
 * @author: 张亮
 * @date: 2021/11/26
 **/
@Data
@ApiModel("手机验证")
public class PhoneVerityVo {
    @ApiModelProperty("手机号码")
    private String phoneNum;
    @ApiModelProperty("验证码")
    private String code;
}
