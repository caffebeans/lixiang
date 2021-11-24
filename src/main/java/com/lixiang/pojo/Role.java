package com.lixiang.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @description:
 * @author: 张亮
 * @date:  2021/10/19
 **/
@Data
@ApiModel("角色")
public class Role {

    @ApiModelProperty("主键")
    private Long id;
    @ApiModelProperty("角色id")
    private String roleCode;
    @ApiModelProperty("角色名称")
    private String name;
    @ApiModelProperty("创建时间")
    private Date created;
    @ApiModelProperty("创建人员")
    private Date creator;
    @ApiModelProperty("更新时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date edited;
    @ApiModelProperty("最新编辑人")
    private Date editor;
    @ApiModelProperty("是否有效")
    private Integer deleted;
}