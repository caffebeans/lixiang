package com.lixiang.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @description:
 * @author: 张亮
 * @date:  2021/10/19
 **/
@Data
@TableName("user_role")
@ApiModel("用户角色表")
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