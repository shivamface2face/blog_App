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

import java.util.List;

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

    //get by user

    @GetMapping("/user/{id}/post")
    public ResponseEntity<List<PostDto>>getPostByUser(@PathVariable Long id){
       List<PostDto>postDto=postService.getPostByUser(id);
        return new ResponseEntity<List<PostDto>>(postDto,HttpStatus.OK);
    }

    //get by cat

    @GetMapping("/category/{id}/post")
    public ResponseEntity<List<PostDto>>getPostByCategory(@PathVariable Long id){
        List<PostDto>postDto=postService.getPostByCategory(id);
        return new ResponseEntity<List<PostDto>>(postDto,HttpStatus.OK);
    }

    //All post

    @GetMapping("/post")
    public ResponseEntity<List<PostDto>>getAllPost(@RequestParam(value ="pageNo",defaultValue = "1")Integer pageNo,
                                                   @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize){

     return ResponseEntity.ok(postService.getAllPost(pageNo,pageSize));
    }

    //sigle Post

    @GetMapping("/post/{id}")
    public ResponseEntity<PostDto>singlePost(@PathVariable Long id){
        return ResponseEntity.ok(postService.singlePost(id));
    }

    //delete Post

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

    //update the post
    @PutMapping("/post/{id}")
    public ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto,@PathVariable Long id){
        PostDto updatedPost=postService.updatePost(postDto,id);
        return ResponseEntity.ok(updatedPost);

    }


}
