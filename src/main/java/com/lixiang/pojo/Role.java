package com.lixiang.pojo;

import java.util.Date;
import lombok.Data;

/**
 * @description:
 * @author: 张亮
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

    private Date edited;

    private Date editor;

    private Integer deleted;
}