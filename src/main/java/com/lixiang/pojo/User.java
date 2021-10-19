package com.lixiang.pojo;

import lombok.Data;

/**
 * @description:
 * @author: 张亮
 * @date:  2021/10/19
 **/
/**
    * user
    */
@Data
public class User {
    /**
    * 唯一索引
    */
    private Integer id;

    /**
    * 登陆名
    */
    private String loginName;

    /**
    * 密码
    */
    private String password;
}