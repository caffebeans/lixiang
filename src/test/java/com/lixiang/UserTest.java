package com.lixiang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lixiang.mapper.RoleMapper;
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
     RoleMapper roleMapper;
    @Test
    void name() {
        roleMapper.selectList(null).forEach(System.out::println);
        //分页查询返回的对象为 IPage 类型的
        IPage<UserInfo> userIPage = new Page<>(2,3);
        //IPage 对象中有很多属性，下面举例几个最常用的
        System.out.println("总记录数---：" + userIPage.getTotal());
        System.out.println("总页数：" + userIPage.getPages());
        System.out.println("当前页面大小：" + userIPage.getSize());
        System.out.println("当前页码：" + userIPage.getCurrent());
        //最重要的  =>  取出查询到的数据
        System.out.println(" ===============   数据   =================");
        List<UserInfo> records = userIPage.getRecords();
        for (UserInfo user : records){
            System.out.println(user);
        }


    }


}
