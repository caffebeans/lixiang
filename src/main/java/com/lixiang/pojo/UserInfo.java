package com.lixiang.pojo;

import java.util.Date;
import lombok.Data;

/**
 * @description:
 * @author: 张亮
 * @date:  2021/10/19
 **/
@Data
public class UserInfo {
    /**
    * 自增主键
    */
    private Long id;

    /**
    * 用户id-
    */
    private Long userId;

    /**
    * 用户名
    */
    private String username;

    /**
    * 登录名
    */
    private String loginName;

    /**
    * 身份证号
    */
    private String idCard;

    /**
    * 性别
    */
    private String gender;

    /**
    * 电话
    */
    private String phone;

    /**
    * 地址
    */
    private String address;

    /**
    * 创建时间
    */
    private Date created;

    /**
    * 创建人-用户名
    */
    private String creator;

    /**
    * 编辑时间
    */
    private Date edited;

    /**
    * 编辑者-用户名
    */
    private String editor;

    /**
    * 状态 0-无效
    */
    private Short status;
}