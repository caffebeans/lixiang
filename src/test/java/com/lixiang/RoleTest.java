package com.lixiang;

import com.lixiang.mapper.RoleMapper;
import com.lixiang.po.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/10/22
 **/

@Slf4j
public class RoleTest extends LixiangApplicationTests{

    @Autowired
    RoleMapper roleMapper;

    @Test
    void add() {
        Role role = new Role();
        roleMapper.selectList(null).forEach(System.out::println);
    }
}
