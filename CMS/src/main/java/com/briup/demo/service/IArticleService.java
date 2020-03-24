package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Article;
import com.briup.demo.utils.CustomerException;

/**
 * 文章相关内容的接口
 * @author Rosschild
 *
 */
public interface IArticleService {
	/**
	 * 新增or修改文章
	 */
	public void saveOrUpdateArticle(Article article) throws CustomerException;
	/**
	 * 删除文章
	 */
	public void deleteArticleById(int id) throws CustomerException;
	/**
	 * 查询文章
	 * @param keyStr
	 * @param condition
	 * @return
	 * @throws CustomerException
	 */
	public List<Article> findArticleByCondition(String keyStr,String condition) throws CustomerException;
	/**
	 * 根据id查询文章
	 */
	public Article findArticleById(int id) throws CustomerException;
	
}
