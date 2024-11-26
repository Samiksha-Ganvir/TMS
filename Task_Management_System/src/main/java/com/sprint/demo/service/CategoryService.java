package com.sprint.demo.service;

import java.util.List;

import com.sprint.demo.entity.Category;

public interface CategoryService {

	List<Category> getAllCategories();

	Category getCategoryById(Integer id);

	Category saveCategory(Category category);

	void deleteCategory(Integer id);

}
