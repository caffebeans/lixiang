package com.lixiang.vo;

import com.lixiang.po.Role;
import com.lixiang.po.UserInfo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/10/22
 **/
@ApiModel("用户角色表")
@Data
public class UserAndRoleVo {

    private List<Role> roles;
    private UserInfo user;

}
