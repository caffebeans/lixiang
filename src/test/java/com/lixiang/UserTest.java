package com.lixiang;

import com.lixiang.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/10/19
 **/
public class UserTest extends LixiangApplicationTests{

     @Autowired
     RoleMapper roleMapper;
    @Test
    void name() {
        roleMapper.selectList(null).forEach(System.out::println);


    }
}
