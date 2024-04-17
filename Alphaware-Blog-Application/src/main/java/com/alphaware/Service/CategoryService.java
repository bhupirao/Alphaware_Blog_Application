package com.alphaware.Service;

import com.alphaware.Exception.CategoryException;
import com.alphaware.Model.Category;

import java.util.List;

public interface CategoryService {

    public Category createCategory(Category category);
    public Category getCategoryById(Integer categoryId)throws CategoryException;
    public List<Category> getAllCategories();
    public Category updateCategory(Integer categoryId, Category categoryDetails)throws CategoryException;
    public void deleteCategory(Integer categoryId)throws CategoryException;

}
