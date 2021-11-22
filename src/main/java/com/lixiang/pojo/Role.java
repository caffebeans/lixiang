package com.lixiang.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @description:
 * @author: 苏铭
 * @date:  2021/10/19
 **/
@Data
public class Role {
    private Long id;

    /**
    * 角色编码
    */
    private String roleCode;

    private String name;

    private Date created;

    private Date creator;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date edited;

    private Date editor;

    private Integer deleted;
}