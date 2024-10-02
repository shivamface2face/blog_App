package com.blogApp.Services.impl;

import com.blogApp.Repostories.CategoryRepo;
import com.blogApp.Repostories.PostRepo;
import com.blogApp.Repostories.UserRepo;
import com.blogApp.Services.PostService;
import com.blogApp.entity.Category;
import com.blogApp.entity.Post;
import com.blogApp.entity.User;
import com.blogApp.exceptions.ResourceNotFoundException;
import com.blogApp.paylods.PostDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
    private final PostRepo postRepo;
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final CategoryRepo categoryRepo;


    @Override
    public PostDto createPost(PostDto postDto, Long cat_Id, Long user_Id) {

        User user=userRepo.findById(user_Id).orElseThrow(()->new ResourceNotFoundException("user is not found with "+user_Id));
        Category category=categoryRepo.findById(cat_Id).orElseThrow(()->new ResourceNotFoundException("Category is not found with "+cat_Id));
        Post post=modelMapper.map(postDto,Post.class);
        post.setImgName("default_Img");
        post.setAddDate(new Date());
        post.setCategory(category);
        post.setUser(user);

        Post savedPost=postRepo.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public Post updatePost(PostDto postDto, Long id) {
        return null;
    }

    @Override
    public void deletePost(Long id) {

    }

    @Override
    public List<PostDto> getAllPost() {
        return List.of();
    }

    @Override
    public Post singlePost(Long id) {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Long category_Id) {
        return List.of();
    }

    @Override
    public List<Post> getPostByUser(Long user_Id) {
        return List.of();
    }

    @Override
    public List<Post> searchPost(String str) {
        return List.of();
    }
}
