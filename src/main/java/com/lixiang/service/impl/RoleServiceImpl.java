package com.lixiang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.lixiang.mapper.RoleMapper;
import com.lixiang.po.Role;
import com.lixiang.service.RoleService;
/**
 * @description:
 * @author: 张亮
 * @date:  2021/10/19
 **/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService{

}
