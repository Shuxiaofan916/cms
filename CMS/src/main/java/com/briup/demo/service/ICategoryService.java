package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.utils.CustomerException;

/**
 * 栏目相关的Service层
 * @author Rosschild
 *
 */
public interface ICategoryService {
	/**
	 * 查询所有栏目
	 */
	public List<Category> findAllCategorys() throws CustomerException;
    
	/**
	 * 添加或修改栏目信息
	 */
	public void saveOrUpdateCategory(Category category) throws CustomerException;
    
	/**
	 * 根据id删除栏目
	 */
	public void deleteCategoryById(int id) throws CustomerException;
	
	/**
	 * 根据栏目名进行查找栏目
	 */
//	public List<Category> findCategorysByName(String name) throws CustomerException;
	
	/**
	 * 根据id查找指定栏目信息
	 */
	public Category findCategoryById(int id) throws CustomerException;
	/**
	 *  查询栏目信息并且及联查询包含的文章信息
	 */
	public List<CategoryEx> findAllCategoryEx() throws CustomerException;

	/**
	 * 查询栏目及其包含文章的所有数据
	 * 本来在IcategoryService中
	 */
	CategoryEx findCategoryExById(int id) throws CustomerException;
}
