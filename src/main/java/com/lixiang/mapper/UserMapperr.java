package com.lixiang.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lixiang.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: 张亮
 * @date:  2021/10/19
 **/
@Mapper
public interface UserMapperr extends BaseMapper<User> {

}