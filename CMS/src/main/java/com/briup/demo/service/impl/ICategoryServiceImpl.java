package com.briup.demo.service.impl;
/**
 * 操作栏目的Service功能类
 * @author Rosschild
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.mapper.ex.CategoryExMapper;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

@Service
public class ICategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private ArticleMapper articlemapper;
	@Autowired
	private CategoryExMapper categoryExMapper;

	@Override
	public List<Category> findAllCategorys() throws CustomerException {
		// TODO Auto-generated method stub
		//模板对象，可以添加参数
		CategoryExample example = new CategoryExample();
		List<Category> alllist = categoryMapper.selectByExample(example);
		return alllist;
	}
	@Override
	public void saveOrUpdateCategory(Category category) throws CustomerException {
		if(category==null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空");
		}
		//无此id则插入 有则更新
		if(category.getId()==null) {
			CategoryExample categoryExampleCode = new CategoryExample();
			//CategoryExample categoryExampleName = new CategoryExample();
			
		//	criteria.andXxxEqualTo(value)    添加xxx字段等于value条件
			//拼接搜索条件
			categoryExampleCode.createCriteria().andCodeEqualTo(category.getCode()).andNameEqualTo(category.getName());
		//	categoryExampleName.createCriteria().andNameEqualTo(category.getName());
			
			//按条件查询
			//List<Category> name = categoryMapper.selectByExample(categoryExampleName);
			List<Category> code = categoryMapper.selectByExample(categoryExampleCode);
			//if(name.size()==0&&code.size()==0) {
			if(code.size()==0) {
				// 无重复，可以存入数据
				categoryMapper.insert(category);
			}else {
				throw new CustomerException(StatusCodeUtil.ERROR_CODE, "栏目已存在");
			}	
			
		}
		else {
			categoryMapper.updateByPrimaryKey(category);
		}
		
	}

	@Override
	public void deleteCategoryById(int id) throws CustomerException {
		// TODO Auto-generated method stub
		categoryMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public Category findCategoryById(int id) throws CustomerException {
		// TODO Auto-generated method stub
//		Category category = categoryMapper.selectByPrimaryKey(id);
//		return category;
		return categoryMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<CategoryEx> findAllCategoryEx() throws CustomerException {
		// TODO Auto-generated method stub
		return categoryExMapper.findAllCategoryEx();
	}
	@Override
	public CategoryEx findCategoryExById(int id) throws CustomerException {
		return categoryExMapper.findCategoryExById(id);
				
	}

}
