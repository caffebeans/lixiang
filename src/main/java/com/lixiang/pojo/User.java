package com.lixiang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @description:
 * @author: 苏铭
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
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
    * 登陆名
    */
    private String loginName;

    /**
    * 密码
    */
    private String password;


    private Integer status;
}