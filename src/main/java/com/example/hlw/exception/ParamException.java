package com.example.hlw.exception;

import com.example.hlw.dto.ResponseCodeEnum;

/**
 * Created by hlw on 2019/8/1.
 */
public class ParamException extends RuntimeException{
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ParamException(String message ) {
        super(message);
        this.setCode(ResponseCodeEnum.MESSAGE_ERROR.getCode().toString());
    }
}
