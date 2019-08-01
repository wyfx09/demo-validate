package com.example.hlw.controller;

import com.example.hlw.dto.UserDto;
import com.example.hlw.utils.ValidateUtils;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by hlw on 2019/8/1.
 */
@RestController
@RequestMapping("demo")
public class DemoController {
    @PostMapping("add")
    public String add(@Validated @RequestBody UserDto userDto){
        return "success";
    }

}
