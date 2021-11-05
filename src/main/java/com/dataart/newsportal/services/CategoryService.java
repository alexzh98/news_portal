package com.dataart.newsportal.services;


import com.dataart.newsportal.entities.Category;

import java.util.List;

public interface CategoryService {

    public Category getCategory(int id);

    public List<Category> getAllCategories();

    public void saveCategory(Category category);

    public void deleteCategory(int id);
}
