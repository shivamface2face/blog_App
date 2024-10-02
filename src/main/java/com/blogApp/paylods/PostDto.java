package com.blogApp.paylods;
import com.blogApp.entity.Category;
import com.blogApp.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    @NotEmpty
    @Size(min = 4,max = 65, message = "  must be 4 char and max upto 65 only")
    private String title;
    @NotEmpty
    @Size(min = 4,max = 115, message = "name must be 4 char and max upto 115 only")
    private String content;
    private String imgName;
    private Date addDate;
    private CategoryDto category;
    private UserDto user;

}
