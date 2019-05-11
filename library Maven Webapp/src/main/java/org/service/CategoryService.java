package org.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.model.Category;

public interface CategoryService {
	//查找一个分类
		public Category queryCategoryById(@Param("id") int id);
	//查询分类
	public List<Category> queryCategory(Integer pid);
	
}
