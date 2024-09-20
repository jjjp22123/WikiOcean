package com.gec.obwiki.exception;

import com.gec.obwiki.resp.CommonResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cr
 * @date 2023年11月08日 15:10
 * @description
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.gec.obwiki.controller")
public class ObwikiExceptionAdvice {

    //编写异常处理方法
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResp handleVaildException(MethodArgumentNotValidException e){
        log.error("数据校验出现问题{},异常类型{}",e.getMessage(),e.getClass());
        BindingResult result = e.getBindingResult();
        Map<String,String> errorMap=new HashMap<>();
        result.getFieldErrors().forEach((item)->{
            String field = item.getField();
            String message = item.getDefaultMessage();
            errorMap.put(field,message);
        });
        return new CommonResp(false,"数据校验异常",errorMap);
    }


    //处理自定义异常
    @ExceptionHandler(BusinessException.class)
    public CommonResp handlerBusinessException(BusinessException e){
        log.error(e.getCode().getDesc(),e);
        return new CommonResp(false,e.getCode().getDesc(),null);
    }


    //处理 系统异常
    @ExceptionHandler(Exception.class)
    public CommonResp handlerException(Exception e){
        log.error(e.getMessage(),e);
        return new CommonResp(false,"未知异常,请联系管理员",null);
    }
}
