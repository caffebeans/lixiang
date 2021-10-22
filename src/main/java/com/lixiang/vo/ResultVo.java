package com.lixiang.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author: 苏铭
 * @date: 2021/10/19
 **/
@Data
@AllArgsConstructor
public class ResultVo {
     private Integer code;
     private String msg;
     private Object data;

    public ResultVo(ResultCode resultCode,Object data) {
        this.code=resultCode.getCode();
        this.msg=resultCode.getMsg();
    }

    public ResultVo(ResultCode resultCode) {
        this.code=resultCode.getCode();
        this.msg=resultCode.getMsg();
    }

    public static ResultVo SUCCESS(){
         ResultVo resultVo = new ResultVo(ResultCode.SUCCESS);
         resultVo.setCode(200);
         resultVo.setMsg("ok");
         return resultVo;
    }

    public static ResultVo SUCCESS(Object data){
        ResultVo resultVo = new ResultVo(ResultCode.SUCCESS);
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVo ERROR(){
        ResultVo resultVo = new ResultVo(ResultCode.ERROR);
        return resultVo;
    }


    public static ResultVo ERROR(ResultCode resultCode){
        ResultVo resultVo = new ResultVo(resultCode);
        return resultVo;
    }

    public static ResultVo ERROR(ResultCode resultCode,Object data){
        ResultVo resultVo = new ResultVo(resultCode);
        resultVo.setData(data);
        return resultVo;
    }

    public ResultVo setCode(Integer code) {
        this.code = code;
        return this;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }
}