package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.Link;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.bean.ex.IndexResult;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.service.IIndexResultService;
import com.briup.demo.service.ILinkService;
import com.briup.demo.utils.CustomerException;

/**
 * 查询首页功能的所有方法
 * @author Rosschild
 *
 */
@Service
public class IndexResultServiceImpl implements IIndexResultService{

	//关联超链接的service接口
	@Autowired
	private  ILinkService linkService;
	@Autowired
	private  ICategoryService categoryService;
/*	@Autowired
	private */
	
	@Override
	public IndexResult findIndexAllResult() throws CustomerException{
		// TODO Auto-generated method stub
		IndexResult indexResult = new IndexResult();
		List<Link> links = linkService.findAllLinks();
		indexResult.setLinks(links);
        List<CategoryEx> categoryExs = categoryService.findAllCategoryEx();
		indexResult.setCategoryExs(categoryExs);
		return indexResult;
	}


}
