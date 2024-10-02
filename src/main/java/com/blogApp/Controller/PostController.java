package com.blogApp.Controller;

import com.blogApp.Services.PostService;
import com.blogApp.Services.impl.PostServiceImpl;
import com.blogApp.entity.Post;
import com.blogApp.paylods.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class PostController {

    @Autowired
    private final PostService postService;

    @PostMapping("/user/{user_Id}/category/{cat_Id}/post")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Long cat_Id,@PathVariable Long user_Id){
        PostDto caretePost=postService.createPost(postDto,cat_Id,user_Id);
        return  new ResponseEntity<PostDto>(caretePost, HttpStatus.CREATED);

    }

}
