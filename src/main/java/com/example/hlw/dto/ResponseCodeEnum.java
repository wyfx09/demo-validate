package com.example.hlw.dto;

/**
 * Created by hlw on 2018/1/2.
 */
public enum ResponseCodeEnum {


    BUSINESS_ERROR(1001, "业务处理失败"),
    SUCEESS(1000, "业务处理成功"),
    C1002(1002, "密码错误，错误次数在message中返回"),
    C1003(003, "密码错误次数过多，此账户已冻结至明日零点；您可于明日进行登录或重置密码"),
    C1004(1004, "账号已经存在"),
    C1005(1005, "服务密码错误，请核对后重新输入"),
    C1006(1006, "图形验证码失效"),
    C1007(1007, "图形验证码错误"),
    C1008(1008, "您输入的手机号尚未注册，请核对后重新输入或前往注册"),
    C1009(1009, "您尚未设置服务密码，请前往设置"),
    C1010(1010, "手机号码格式错误"),
    VERIFY_FAIL(1011,"验签失败"),
    MESSAGE_ERROR(1013,"请求参数错误"),
    C1012(1012, "账户户名或账户号码错误，请核对后重新输入企业用户登录"),

    C1014(1014, "短信验证码失效"),
    C1015(1015, "短信验证码错误"),
    C1016(1016, "该号码今日已获取五次验证码，请明日再试"),
    PAY_CHANNEL_NO_ERROR(1017,"支付渠道不存在"),
    SYSTEM_ERROR(2001, "系统内部异常");

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    ResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
