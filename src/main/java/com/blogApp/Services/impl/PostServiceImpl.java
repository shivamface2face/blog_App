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
import java.util.stream.Collectors;

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
    public PostDto updatePost(PostDto postDto, Long id) {
        Post post=postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("post not found with"+id));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImgName(post.getImgName());
        Post updatePost=postRepo.save(post);
        return modelMapper.map(updatePost,PostDto.class);
    }

    @Override
    public void deletePost(Long id) {
           postRepo.deleteById(id);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post>allPost=postRepo.findAll();
       List<PostDto>getAll=allPost.stream().map((post ->
                modelMapper.map(post,PostDto.class)
                )).collect(Collectors.toList());
       return getAll;
    }

    @Override
    public PostDto singlePost(Long id) {
        Post post=postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("post not found with"+id));
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Long category_Id) {

        Category cat=categoryRepo.findById(category_Id).orElseThrow(()->new ResourceNotFoundException("cat is not found "+category_Id));

        List<Post>posts=postRepo.findByCategory(cat);

        List<PostDto>postDtos=posts.stream().map((post->
            modelMapper.map(post,PostDto.class)
        )).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Long user_Id) {
        User user=userRepo.findById(user_Id).orElseThrow(()->new ResourceNotFoundException("user is not found with "+user_Id));
        List<Post>posts=postRepo.findByUser(user);
        List<PostDto>postDtos=posts.stream().map((post ->
                modelMapper.map(post, PostDto.class)
                )).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> searchPost(String str) {
        return List.of();
    }
}
