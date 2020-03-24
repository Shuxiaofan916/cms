package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 和前端交互的web层
 * @author Rosschild
 *
 */

@RestController
@Api(description="栏目相关接口")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	/**
	 * 新增栏目信息
	 * @param category
	 * @return
	 */
	//post不会显示
	@PostMapping("/addCategory")
	@ApiOperation("新增栏目")
	public Message<String> addCategory(Category category){
		try {
			categoryService.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误"+e.getMessage());

		}
		/**
		 * 查询栏目信息
		 */
	}
	@PostMapping("/selectCategorys")
	@ApiOperation("查询所有栏目信息")
	public Message<List<Category>> selectCategorys(){
		List<Category> categorys = categoryService.findAllCategorys();
		return MessageUtil.success(categorys);
	}
	
	/**
	 * 删除栏目信息     
	 */
	@GetMapping("/deleteCategory")
	@ApiOperation("删除栏目信息")
	public Message<String> deleteById(int id){
		categoryService.deleteCategoryById(id);
		return MessageUtil.success();
	}
	/**
	 * 查询指定栏目信息
	 */
	@PostMapping("/selectCategory")
	@ApiOperation("查询指定栏目信息")
	public Message<Category> selectCategory(int id){
		Category category = categoryService.findCategoryById(id);
		return MessageUtil.success(category);
	}
	
	/**
	 * 根据ID查找栏目及其包含的所有文章信息
	 */
	@GetMapping("/findCategoryExById")
	@ApiOperation("根据栏目ID查找栏目及其文章信息")
	public Message<CategoryEx> findCategoryExById(int id){
		return MessageUtil.success(categoryService.findCategoryExById(id));
	}
	

}
