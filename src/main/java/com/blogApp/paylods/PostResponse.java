package com.blogApp.paylods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private List<PostDto>content;
    private int pageNo;
    private int pageSize;
    private  Long totalElement;
    private int totalPage;
    private boolean lastPage;

}
