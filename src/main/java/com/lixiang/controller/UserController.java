package com.lixiang.controller;

import com.lixiang.mapper.UserMapperr;
import com.lixiang.pojo.UserInfo;
import com.lixiang.service.UserInfoService;
import com.lixiang.service.UserService;
import com.lixiang.vo.ResultCode;
import com.lixiang.vo.ResultVo;
import com.lixiang.vo.UserAndRoleVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/10/20
 **/
@RestController
@Slf4j
@RequestMapping("/v1/user")
@Api(tags="用户管理")
public class UserController {

      @Autowired
      UserInfoService userInfoServiceService;
      @Autowired
      UserService userService;
      @Autowired
      UserMapperr userMapper;

    @GetMapping("/")
    public ResultVo list(@RequestParam Map<String,String> map){

        Object o = userService.pageSearch(map);

        return ResultVo.SUCCESS(o);
    }

    @PostMapping("/add")
    public ResultVo post(@RequestBody Map<String,String> map){
        log.info("添加用户");
        boolean res=false;
        res=userService.insert(map);
        return res?ResultVo.SUCCESS():ResultVo.ERROR(ResultCode.ROLE_UPDATE_ERROR);
    }


    @RequestMapping("/update")
    public ResultVo update(@RequestBody UserInfo userInfo){
        log.info("更新用户");
        boolean res;
        try{
            res = userInfoServiceService.updateById(userInfo);
        }catch(Exception e) {
            return ResultVo.ERROR();
        }
        return res?ResultVo.SUCCESS():ResultVo.ERROR(ResultCode.ROLE_UPDATE_ERROR);
    }

    @GetMapping("/banUserById")
    @Transactional
    public ResultVo banUserById(@RequestParam("login_name") String loginName){

        boolean res=userService.banUserLoginName(loginName);

        return res?ResultVo.SUCCESS():ResultVo.ERROR(ResultCode.ROLE_DEL_ERROR);
    }

    @GetMapping("/searchByUserNameOrId")
    @Transactional
    public ResultVo searchByUserNameOrId(@RequestParam Map<String,String> map){

        List<UserInfo> list = userService.searchByUserNameOrID(map);
        if (list.size()==0) return ResultVo.SUCCESS();

        return ResultVo.SUCCESS(list).setCode(200);
    }

    @PostMapping("/editUserRole")
    public ResultVo editUserRole(@RequestBody UserAndRoleVo userAndRoleVo){
//       List<Role> roleList= (List<Role>) map.get("roles");

        log.info("编辑用户的角色");
        boolean res=false;
        res = userService.editUserRole(userAndRoleVo);

        return res?ResultVo.SUCCESS():ResultVo.ERROR(ResultCode.ROLE_UPDATE_ERROR);
    }





}
