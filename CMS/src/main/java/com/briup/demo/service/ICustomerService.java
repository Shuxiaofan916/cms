package com.briup.demo.service;

import com.briup.demo.bean.Customer;
import com.briup.demo.utils.CustomerException;

public interface ICustomerService {
	/**
	 * 注册 or 登陆 用户信息 
	 */
	public void saveOrloginCustomer(Customer customer) throws CustomerException;
	/**
	 * 判断用户信息与数据库是否一致
	 */
	

}
