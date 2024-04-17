package com.alphaware.Controller;


import com.alphaware.Exception.CategoryException;
import com.alphaware.Model.Category;
import com.alphaware.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    @PostMapping("/createCat")
    public ResponseEntity<Category> createCategoryHandler(@RequestBody Category category) {

        Category category1=categoryService.createCategory(category);

        return new ResponseEntity<>(category1, HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryByIdHandler(@PathVariable Integer categoryId)throws CategoryException {
        Category category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/allCat")
    public ResponseEntity<List<Category>> getAllCategoriesHandler() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategoryHandler(@PathVariable Integer categoryId,@RequestBody Category categoryDetails)throws CategoryException {
        Category updatedCategory = categoryService.updateCategory(categoryId, categoryDetails);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategoryHandler(@PathVariable Integer categoryId)throws CategoryException {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    }
