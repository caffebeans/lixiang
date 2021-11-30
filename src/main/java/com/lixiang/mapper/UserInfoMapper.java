package com.lixiang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lixiang.po.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: 张亮
 * @date:  2021/10/19
 **/
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}