package com.example.hlw.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by hlw on 2019/8/1.
 */
@Data
public class UserDto {
    @NotBlank(message = "name不能为空")
    private String name;
    @NotNull(message = "age不能为空")
    private Integer age;
}
