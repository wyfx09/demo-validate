package com.example.hlw.component;

import com.example.hlw.dto.BaseResponse;
import com.example.hlw.dto.ResponseCodeEnum;
import com.example.hlw.exception.ParamException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Created by hlw on 2018/1/3.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public @ResponseBody
    BaseResponse<String> handleException(Exception e) {
        BaseResponse<String> response = new BaseResponse<String>();
        response.fail();
        e.printStackTrace();
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody
    BaseResponse<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BaseResponse<String> response = new BaseResponse<String>();
        StringBuilder sb = new StringBuilder();
        for (ObjectError err : e.getBindingResult().getAllErrors()) {
            sb.append(err.getDefaultMessage() + ";");
        }
        response.fail(ResponseCodeEnum.MESSAGE_ERROR.getCode().toString(), sb.toString());
        e.printStackTrace();
        return response;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public @ResponseBody
    BaseResponse<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        BaseResponse<String> response = new BaseResponse<String>();
        response.fail(ResponseCodeEnum.MESSAGE_ERROR.getCode().toString(), "请求参数异常");
        e.printStackTrace();
        return response;
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public @ResponseBody
    BaseResponse<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        BaseResponse<String> response = new BaseResponse<String>();
        response.fail(ResponseCodeEnum.MESSAGE_ERROR.getCode().toString(), "请求参数异常");
        e.printStackTrace();
        return response;
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody
    BaseResponse<String> handleRunningException(RuntimeException e) {
        e.printStackTrace();
        BaseResponse<String> response = new BaseResponse<String>();
        response.fail(ResponseCodeEnum.BUSINESS_ERROR.getCode().toString(), e.getMessage());
        return response;
    }

    @ExceptionHandler(ParamException.class)
    public @ResponseBody
    BaseResponse<String> handleParamException(ParamException e) {
        e.printStackTrace();
        BaseResponse<String> response = new BaseResponse<String>();
        response.fail(ResponseCodeEnum.MESSAGE_ERROR.getCode().toString(), e.getMessage());
        return response;
    }

}
