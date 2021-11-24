package com.lixiang.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lixiang.mapper.UserMapperr;
import com.lixiang.pojo.UserInfo;
import com.lixiang.service.UserInfoService;
import com.lixiang.service.UserService;
import com.lixiang.vo.ResultCode;
import com.lixiang.vo.ResultVo;
import com.lixiang.vo.UserAndRoleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.util.annotation.Nullable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
@Api(tags="用户管理",description = "用来对用户进行增管理")
@Validated
public class UserController {

      @Autowired
      UserInfoService userInfoServiceService;
      @Autowired
      UserService userService;
      @Autowired
      UserMapperr userMapper;

    @GetMapping("/")
    @ApiOperation("查询所有用户的信息")
    @ApiOperationSupport(author = "张亮")
    public ResultVo list(@RequestParam Map<String,String> map){
        Object o = userService.pageSearch(map);
        return ResultVo.SUCCESS(o);
    }

    @GetMapping("/page")
    @ApiImplicitParam(name = "pageNo",value = "当前页数",required = true)
    @ApiOperation("分页查询")
    public ResultVo pageList(@Range(min = 0,max = Integer.MAX_VALUE/2) Integer pageNo, @Min(1) @Max(1000) Integer pageSize){

        System.out.println("****************************************");
        System.out.println("分页查询 ");
        System.out.println(pageNo);
        System.out.println(pageSize);
        return ResultVo.SUCCESS();
    }

    @PostMapping("/add")
    @ApiOperation("新增用户")
    public ResultVo post(@RequestBody Map<String,String> map){
        log.info("添加用户");
        boolean res=false;
        res=userService.insert(map);
        return res?ResultVo.SUCCESS():ResultVo.ERROR(ResultCode.ROLE_UPDATE_ERROR);
    }


    @PostMapping(value = "/update")
    @ApiOperation("更新用户")
    @ModelAttribute
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
