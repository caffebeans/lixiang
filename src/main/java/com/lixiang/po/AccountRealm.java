package com.lixiang.po;

import com.lixiang.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/11/30
 **/
public class AccountRealm extends AuthorizingRealm {


    @Autowired
    UserService userService;

    /**
     * 授权方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        User primaryPrincipal = (User)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 硬编码（赋予用户权限或角色）
        info.addRole("admin");

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = new User();
        user.setLoginName(token.getUsername());
        user.setPassword(String.valueOf(token.getPassword()));
        User profile = userService.login(user);
        if (profile==null) return null;
        // 把用户信息存到session中，方便前端展示
        // SecurityUtils.getSubject().getSession().setAttribute("profile", profile);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(profile, user.getPassword(), getName());
        return info;
    }
}
