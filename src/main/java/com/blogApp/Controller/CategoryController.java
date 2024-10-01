package com.blogApp.Controller;

import com.blogApp.Services.CategoryService;
import com.blogApp.Services.impl.CategoryServiceImpl;
import com.blogApp.paylods.CategoryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    // craete
    @PostMapping
    public ResponseEntity<CategoryDto>createCategory(@Valid @RequestBody CategoryDto categoryDto){
       CategoryDto categoryDto1=categoryService.createCategory(categoryDto);
       return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }

    // update

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto>updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Long id){
        CategoryDto updateCategory=categoryService.updateCategory(categoryDto,id);
        return new ResponseEntity<>(updateCategory,HttpStatus.OK );
    }


    //delte

    @DeleteMapping("/id")
    public void deleteCategory(@PathVariable Long id){
         categoryService.deleteCategory(id);
    }


    // getSinle

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto>getSingleCategory(@PathVariable Long id){
        CategoryDto getSingleCat=categoryService.getSingleCategory(id);
        return new ResponseEntity<>(getSingleCat,HttpStatus.OK );
    }






    // getAll

    @GetMapping
    public ResponseEntity<List<CategoryDto>>getAllCategory(){
      List<CategoryDto> getAllCat=categoryService.getAllCategory();
        return  ResponseEntity.ok(getAllCat);
    }

}
