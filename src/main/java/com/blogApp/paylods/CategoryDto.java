package com.blogApp.paylods;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private Long categoryId;

    @NotEmpty
    @Size(min = 4,max = 15, message = "Category title must be 4 char and max upto 8 char only")
    private String categoryTitle;
    @NotEmpty
    @Size(min = 4,max = 25, message = "Cateogory discriptions must be 4 char and max upto 25 char only")
    private String categoryDescription;
}
