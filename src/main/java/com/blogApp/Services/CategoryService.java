package com.blogApp.Services;

import com.blogApp.paylods.CategoryDto;

import java.util.List;

public interface CategoryService {

    //craete
     CategoryDto createCategory(CategoryDto categoryDto);

    // update

     CategoryDto updateCategory(CategoryDto categoryDto,Long categoryId);

    //delete
     void deleteCategory(Long categoryId);

    // getSingle

     CategoryDto getSingleCategory(long categoryId);

    // getAll Cat

     List<CategoryDto>getAllCategory();
}
