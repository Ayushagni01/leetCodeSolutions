package com.examServer.ExamServer.service;

import com.examServer.ExamServer.model.exam.Category;

import java.util.Set;

public interface CategoryService {

    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Set<Category> getCategories();
    public Category getCategory(Long id);
    public void deleteCategory(Long id);


}
