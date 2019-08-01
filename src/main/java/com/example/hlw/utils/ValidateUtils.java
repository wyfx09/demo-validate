package com.example.hlw.utils;

import com.example.hlw.exception.ParamException;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by admin on 2017/12/25.
 */
public class ValidateUtils {
    /**
     * 带注解的参数验证
     * @param o
     */
    public static void validate(Object o) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        StringBuilder sb = new StringBuilder();
        Set<ConstraintViolation<Object>> set = validator.validate(o);
        for (ConstraintViolation<Object> constraintViolation : set) {
            sb.append(constraintViolation.getMessage()+";");
        }
        if(sb.length() > 0){
            throw new ParamException(sb.toString());
        }
    }

    /**
     *  验证参数不能为空
     * @param value
     * @param message
     */
    public static void singleValidateNotEmpty(Object value,String message ){
        if(null == value){
            throw new ParamException(message);
        }
        if(value instanceof String){
            if(((String) value).length() <=0){
                throw new ParamException(message);
            }
        }
        if(value instanceof List){
            if(((List) value).size()<=0){
                throw new ParamException(message);
            }
        }
    }

    /**
     * 字符串 验证
     * @param value
     * @param message
     */
    public static void singleValidateNotBlank(String value ,String message){
        if(StringUtils.isBlank(value)){
            throw new ParamException(message);
        }
    }

    /**
     * 正则表达式验证
     * @param value
     * @param regexp
     * @param message
     */
    public static void singleValidatePattern(String value ,String regexp,String message){
        Pattern pattern = Pattern.compile("^"+regexp+"$");
        if( !pattern.matcher(value).matches()){
            throw new ParamException(message);
        }
    }

}
