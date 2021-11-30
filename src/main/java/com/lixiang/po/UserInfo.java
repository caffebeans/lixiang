package com.lixiang.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @description:
 * @author: 张亮
 * @date:  2021/10/19
 **/
@Data
@TableName("user_info")
@ApiModel("用户基本表")
public class UserInfo {
    /**
    * 自增主键
    */
    @TableId(value = "id",type = IdType.AUTO)
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
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;

    /**
    * 创建人-用户名
    */
    private String creator;

    /**
    * 编辑时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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