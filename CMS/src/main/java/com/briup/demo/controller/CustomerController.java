package com.briup.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.Customer;
import com.briup.demo.service.ICustomerService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description="登陆相关接口")
public class CustomerController {
	
	private ICustomerService customerService;
	
	@PostMapping("/saveorloginCustomer")
	@ApiOperation("注册或登陆  //输入创建时给的id算登陆")
	public Message<String> addCategory(Customer customer){
		try {
			customerService.saveOrloginCustomer(customer);
			return MessageUtil.success();
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "登陆错误"+e.getMessage());

		}
}
}