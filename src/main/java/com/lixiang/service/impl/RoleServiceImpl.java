package com.lixiang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lixiang.mapper.RoleMapper;
import com.lixiang.pojo.Role;
import com.lixiang.service.RoleService;
/**
 * @description:
 * @author: 苏铭
 * @date:  2021/10/19
 **/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService{

}
