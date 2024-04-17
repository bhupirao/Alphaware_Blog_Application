package com.alphaware.Service.Impl;

import com.alphaware.Exception.CategoryException;
import com.alphaware.Model.Category;
import com.alphaware.Repository.CategoryRepo;
import com.alphaware.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category getCategoryById(Integer categoryId) throws CategoryException {
        Optional<Category> opt=categoryRepo.findById(categoryId);
        if(opt.isPresent()){
            return opt.get();
        }throw new CategoryException("CategoryId not found!");
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category updateCategory(Integer categoryId, Category categoryDetails) throws CategoryException {

        Optional<Category> opt=categoryRepo.findById(categoryId);
        if(opt.isPresent()){
            Category category=opt.get();
            category.setTitle(categoryDetails.getTitle());
            return categoryRepo.save(category);
        }throw new CategoryException("CategoryId not found!");
    }

    @Override
    public void deleteCategory(Integer categoryId) throws CategoryException {

        Optional<Category> opt=categoryRepo.findById(categoryId);
        if(opt.isPresent()){
            categoryRepo.delete(opt.get());
            return ;
        }throw new CategoryException("CategoryId not found!");
    }
}
