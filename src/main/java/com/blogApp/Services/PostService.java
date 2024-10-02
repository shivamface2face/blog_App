package com.blogApp.Services;

import com.blogApp.entity.Category;
import com.blogApp.entity.Post;
import com.blogApp.entity.User;
import com.blogApp.paylods.PostDto;

import java.util.List;

public interface PostService {

    //create

    PostDto createPost(PostDto postDto, Long cat_Id, Long user_Id);

    // update
    Post updatePost(PostDto postDto,Long id);



    //delete post

    void deletePost(Long id);

    // all post

    List<PostDto>getAllPost();

    // singlePost

    Post singlePost(Long id);

    // get post by category

    List<Post>getPostByCategory(Long category_Id);

    // get post by user

    List<Post>getPostByUser(Long user_Id);

    // search post

    List<Post>searchPost(String str);
}
