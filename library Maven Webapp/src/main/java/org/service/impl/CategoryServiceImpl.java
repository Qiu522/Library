package org.service.impl;

import java.util.List;


import org.dao.CategoryDao;
import org.model.Category;
import org.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
    private CategoryDao categoryDao;
	
	@Override
	public Category queryCategoryById(int id) {
		return categoryDao.queryCategoryById(id);
	}
	
	@Override
	public List<Category> queryCategory(Integer pid) {
		
		return categoryDao.queryCategory(pid);
	}

}
