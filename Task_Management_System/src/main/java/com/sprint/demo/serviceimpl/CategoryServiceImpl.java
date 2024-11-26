package com.sprint.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.demo.entity.Category;
import com.sprint.demo.repository.CategoryRepository;
import com.sprint.demo.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

 @Autowired
 private CategoryRepository categoryRepository;

 @Override
 public List<Category> getAllCategories() {
     return categoryRepository.findAll();
 }

 @Override
 public Category getCategoryById(Integer id) {
     Optional<Category> category = categoryRepository.findById(id);
     return category.orElse(null); // or throw an exception based on your needs
 }

 @Override
 public Category saveCategory(Category category) {
     return categoryRepository.save(category);
 }

 @Override
 public void deleteCategory(Integer id) {
     categoryRepository.deleteById(id);
 }
}

