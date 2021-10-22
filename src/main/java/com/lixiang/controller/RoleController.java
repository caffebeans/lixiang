package com.lixiang.controller;

import com.lixiang.mapper.RoleMapper;
import com.lixiang.pojo.Role;
import com.lixiang.pojo.User;
import com.lixiang.service.RoleService;
import com.lixiang.vo.ResultCode;
import com.lixiang.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 苏铭
 * @date: 2021/10/19
 **/
@RestController
@RequestMapping("/v1/role")
@Slf4j
public class RoleController {

     @Autowired
     RoleService roleService;

     @RequestMapping("/")
    public ResultVo list(){
         log.info("查看所有的角色");
         List<Role> roles = roleService.list(null);
         return ResultVo.SUCCESS(roles);
     }

    @PostMapping("/add")
    public ResultVo post(@RequestBody Role role){
        log.info("添加角色");
        log.info(role.toString());
        role.setCreated(new Date());
        role.setEdited(new Date());
        boolean res;
        try{
            res = roleService.save(role);
        }catch(Exception e) {
            return ResultVo.ERROR();
        }
        return res?ResultVo.SUCCESS():ResultVo.ERROR(ResultCode.ROLE_UPDATE_ERROR);
    }


    @RequestMapping("/update")
    public ResultVo update(@RequestBody Role role){
        log.info("更新角色");
        boolean res;
        try{
            res = roleService.updateById(role);
        }catch(Exception e) {
            return ResultVo.ERROR();
        }
        return res?ResultVo.SUCCESS():ResultVo.ERROR(ResultCode.ROLE_UPDATE_ERROR);
    }

    @GetMapping("/del")
    public ResultVo del(@RequestParam Map<String,String> map){

        log.info("删除角色");
        Role role = new Role();
        role.setId(Long.valueOf(map.get("id")));
        role.setRoleCode("name");
        boolean res;
        try{
            res = roleService.removeById(role.getId());
        }catch(Exception e) {
            return ResultVo.ERROR();
        }
        return res?ResultVo.SUCCESS():ResultVo.ERROR(ResultCode.ROLE_DEL_ERROR);
    }


}
