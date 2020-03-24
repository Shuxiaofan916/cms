package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.briup.demo.bean.CategoryExample;
import com.briup.demo.bean.Customer;
import com.briup.demo.bean.CustomerExample;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.mapper.CustomerMapper;
import com.briup.demo.service.ICustomerService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

@Service
public class CustomerServiceImpl implements ICustomerService{

	
	private CustomerMapper customermapper;
	
	@Override
	public void saveOrloginCustomer(Customer customer) throws CustomerException {
		if(customer==null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "用户为空");
		}
		if(customer.getId()==null) {
			customermapper.insert(customer);
		}else {
			CustomerExample example = new CustomerExample();
			example.createCriteria().andIdEqualTo(customer.getId()).andUsernameEqualTo(customer.getUsername()).andPasswordEqualTo(customer.getPassword());
			List<Customer> list = customermapper.selectByExample(example);
			if(list.size()!=0) {
			//	反馈登陆成功
			}else {
				throw new CustomerException(StatusCodeUtil.ERROR_CODE, "id或账号或密码 输入错误     这是思路是输入id则登陆 不输入则是创建新用户");
			}

		}
		
	}

}
