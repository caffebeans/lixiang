package com.lixiang.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;
import com.lixiang.po.UserRole;
import com.lixiang.service.UserRoleService;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * @description:
 * @author: 张亮
 * @date:  2021/10/19
 **/
@Service
public class UserRoleServiceImpl implements UserRoleService{


    @Override
    public boolean saveBatch(Collection<UserRole> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<UserRole> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<UserRole> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(UserRole entity) {
        return false;
    }

    @Override
    public UserRole getOne(Wrapper<UserRole> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<UserRole> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<UserRole> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<UserRole> getBaseMapper() {
        return null;
    }
}


