package com.dataart.newsportal.services_impl;

import com.dataart.newsportal.entities.Article;
import com.dataart.newsportal.entities.Category;
import com.dataart.newsportal.repositories.CategoryRepository;
import com.dataart.newsportal.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category getCategory(int id) {
        Category category = null;
        Optional<Category> optional = categoryRepository.findById(id);

        if (optional.isPresent()){
            category = optional.get();
        }

        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
