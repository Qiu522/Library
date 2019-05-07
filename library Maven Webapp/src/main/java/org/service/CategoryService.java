package org.service;

import java.util.List;

import org.model.Category;

public interface CategoryService {
	//查询分类
	public List<Category> queryCategory(Integer pid);
	
}
