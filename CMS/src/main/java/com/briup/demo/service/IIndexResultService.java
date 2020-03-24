package com.briup.demo.service;

import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.bean.ex.IndexResult;
import com.briup.demo.utils.CustomerException;

/**
 * 首页数据管理的service层接口
 * @author Rosschild
 *
 */
public interface IIndexResultService {
	
	IndexResult findIndexAllResult();

	
}
