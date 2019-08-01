package com.example.hlw;

import com.example.hlw.dto.UserDto;
import com.example.hlw.utils.ValidateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class DemoValidateApplicationTests {

	/**
	 *  正则表达式
	 */
	@Test
	public void contextLoads() {
		ValidateUtils.singleValidatePattern("1","1|2","name只能为0|1");
	}

	@Test
	public void StringValidate( ){
		Integer age=null;
		ValidateUtils.singleValidateNotEmpty(age,"age不能为空");
	}
	@Test
	public void StringValidateList( ){
		List<String> age=new ArrayList<>();
		ValidateUtils.singleValidateNotEmpty(age,"age不能为空");
	}

	@Test
	public void StringValidateObject( ){
		UserDto user =new UserDto();
		ValidateUtils.validate(user );
	}
}
