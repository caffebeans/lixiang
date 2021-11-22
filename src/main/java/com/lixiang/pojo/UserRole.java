package com.lixiang.pojo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description:
 * @author: 张亮
 * @date:  2021/10/19
 **/
@Data
@TableName("user_role")
public class UserRole {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
    * 用户id
    */
    private Long userId;

    /**
    * 角色id
    */
    private Long roleId;


}