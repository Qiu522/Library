package org.dao;

import java.util.List;


import org.model.Category;

public interface CategoryDao {
	public List<Category> queryCategory(Integer pid);
}
