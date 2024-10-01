package com.blogApp.Services.impl;

import com.blogApp.Repostories.CategoryRepo;
import com.blogApp.Services.CategoryService;
import com.blogApp.entity.Category;
import com.blogApp.exceptions.ResourceNotFoundException;
import com.blogApp.paylods.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryRepo categoryRepo;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat=modelMapper.map(categoryDto,Category.class);
        Category savedCat=categoryRepo.save(cat);
        return modelMapper.map(savedCat,CategoryDto.class);
    }


    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Category cat=categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category is not found with this id"+ categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updatedCat=categoryRepo.save(cat);
        return modelMapper.map(updatedCat,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Long categoryId) {
       categoryRepo.deleteById(categoryId);
    }

    @Override
    public CategoryDto getSingleCategory(long categoryId) {
        Category cat=categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category is not found with this id"+ categoryId));
        return modelMapper.map(cat,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
       List<Category>list= categoryRepo.findAll();
      List<CategoryDto>li=list.stream().map((cat)->modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
      return li;
    }
}
