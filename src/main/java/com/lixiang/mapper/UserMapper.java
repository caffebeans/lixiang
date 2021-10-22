package com.lixiang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lixiang.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: 苏铭
 * @date:  2021/10/19
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}