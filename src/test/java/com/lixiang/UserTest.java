package com.lixiang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lixiang.mapper.RoleMapper;
import com.lixiang.mapper.UserInfoMapper;
import com.lixiang.pojo.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:
 * @author: 苏铭
 * @date: 2021/10/19
 **/
public class UserTest extends LixiangApplicationTests{

     @Autowired
     UserInfoMapper userInfoMapper;
    @Test
    void name() {
        Page<UserInfo> page = new Page<> (1,1);
        //查询第pageNum页，每页pageSize条数据
//将分页参数page作为Mybatis或Mybatis Plus的第一个参数传入持久层函数，即可完成分页查询

        page=userInfoMapper.selectPage(page, null );



    }


}
