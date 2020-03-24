package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Link;
import com.briup.demo.utils.CustomerException;

/**
 * 关于链接的service层
 * @author Rosschild
 *
 */
public interface ILinkService {
	/**
	 * 保存链接信息
	 * @param link
	 */
	void saveOrUpdateLink(Link link) throws CustomerException;

	/**
	 *  查询所有链接信息
	 */
	List<Link> findAllLinks() throws CustomerException;
	/**
	 * 根据id删除对应链接
	 */
	void deleteLinkById(int id) throws CustomerException;
	/**
	 * 根据链接名查询链接
	 */
	List<Link> findLinksByName(String name) throws CustomerException;
	
}
