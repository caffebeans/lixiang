package com.lixiang.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description:
 * @author: 苏铭
 * @date:  2021/10/19
 **/
@Data
@TableName("t_user_info")
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
    private Integer gender;

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
    private Integer status;
}