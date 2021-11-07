package com.examServer.ExamServer.service.impl;

import com.examServer.ExamServer.model.exam.Category;
import com.examServer.ExamServer.repo.CategoryRepository;
import com.examServer.ExamServer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {

        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long id) {
        return this.categoryRepository.findById(id).get();
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = new Category();
        category.setCid(id);
        this.categoryRepository.delete(category);
    }
}
