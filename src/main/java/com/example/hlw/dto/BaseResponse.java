package com.example.hlw.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by hlw on 2018/1/2.
 */
public class BaseResponse<T> implements Serializable {

    private String code = ResponseCodeEnum.SUCEESS.getCode().toString();
    private String message = ResponseCodeEnum.SUCEESS.getMessage();
    private String traceId;
    private Date resDate;
    private String signData;
    private T data;

    public BaseResponse() {
        this.setResDate(new Date());
        this.code = ResponseCodeEnum.SUCEESS.getCode().toString();
        this.message = ResponseCodeEnum.SUCEESS.getMessage();

    }


    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = new Date();
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getSignData() {
        return signData;
    }

    public void setSignData(String signData) {
        this.signData = signData;
    }

    public BaseResponse<T> failByBiz(String message) {
        this.setCode(ResponseCodeEnum.BUSINESS_ERROR.getCode().toString());
        this.setMessage(message);
        return this;
    }

    public BaseResponse<T> fail(String message) {
        this.setCode(ResponseCodeEnum.SYSTEM_ERROR.getCode().toString());
        this.setMessage(message);
        return this;
    }

    public BaseResponse<T> fail() {
        this.setCode(ResponseCodeEnum.SYSTEM_ERROR.getCode().toString());
        this.setMessage(ResponseCodeEnum.SYSTEM_ERROR.getMessage());
        return this;
    }

    public BaseResponse<T> fail(String code, String message) {
        if (code.equals(ResponseCodeEnum.SUCEESS.getCode().toString())) {
            throw new RuntimeException("cannot set code equals 200(status=success)");
        }
        this.setCode(code);
        this.setMessage(message);
        return this;
    }

    public BaseResponse<T> fail(ResponseCodeEnum codeEnum) {
        if (codeEnum == ResponseCodeEnum.SUCEESS) {
            throw new RuntimeException("cannot set code equals 200(status=success)");
        }
        this.setCode(codeEnum.getCode().toString());
        this.setMessage(codeEnum.getMessage());
        return this;
    }

    public BaseResponse<T> succeed() {
        this.setCode(ResponseCodeEnum.SUCEESS.getCode().toString());
        this.setMessage(ResponseCodeEnum.SUCEESS.getMessage());
        return this;
    }
    public BaseResponse succeed(T data){
        this.setData(data);
        this.succeed();
        return this;
    }

    public Boolean successful() {
        if (this.getCode().equals(ResponseCodeEnum.SUCEESS.getCode().toString())) {
            return true;
        }
        return false;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
