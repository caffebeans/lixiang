package com.lixiang.exception;


import com.lixiang.vo.ResultCode;
import com.lixiang.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContextUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    /**
     * 未知异常处理
     * @param request 请求
     * @param ex 异常对象
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultVo handlerMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex){

        Locale locale = RequestContextUtils.getLocale(request);
        BindingResult br = ex.getBindingResult();
        StringBuilder msgStr = new StringBuilder();
        List<FieldError> feList = br.getFieldErrors();
        for (FieldError fe : feList) {
            String message = fe.getDefaultMessage();
            String field = fe.getField();
            msgStr.append(field).append(message).append("; ");
        }

        System.out.println(msgStr);
        return ResultVo.ERROR(ResultCode.ArgumentType);
    }

    /**
     * 未知异常处理
     * @param request 请求
     * @param ex 异常对象
     */
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultVo handlerException(HttpServletRequest request, Exception ex){
        System.out.println(ex+"----");
        return ResultVo.ERROR(ResultCode.ArgumentType);
    }


}