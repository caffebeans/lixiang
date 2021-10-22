package com.lixiang.vo;

import com.lixiang.pojo.Role;
import com.lixiang.pojo.UserInfo;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/10/22
 **/
@Data
public class UserAndRoleVo {

    private List<Role> roles;
    private UserInfo user;

}
