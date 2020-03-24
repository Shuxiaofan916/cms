package com.briup.demo.mapper.ex;

import java.util.List;

import com.briup.demo.bean.ex.CategoryEx;

/**
 * 处理 查询栏目及其包含的文章信息
 * @author Rosschild
 *
 */
public interface CategoryExMapper {
	/**
	 * 实现查询所有栏目及其包含的文章信息
	 * @return
	 */
	List<CategoryEx> findAllCategoryEx();
	/**
	 * 通过Id查询对应栏目及其包含的文章信息
	 */
	CategoryEx findCategoryExById(int id);

}
