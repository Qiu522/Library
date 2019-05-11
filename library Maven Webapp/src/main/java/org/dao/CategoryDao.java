package org.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.model.Category;

public interface CategoryDao {
	//查找一个分类
	public Category queryCategoryById(@Param("id") int id);
	//查找子分类
	public List<Category> queryCategory(@Param("pid") int pid);
}
