package com.blogApp.Services.impl;

import com.blogApp.Repostories.CommentRepo;
import com.blogApp.Repostories.PostRepo;
import com.blogApp.Services.CommentService;
import com.blogApp.entity.Comment;
import com.blogApp.entity.Post;
import com.blogApp.exceptions.ResourceNotFoundException;
import com.blogApp.paylods.CommentDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    @Autowired
    private final PostRepo postRepo;
    @Autowired
    private final CommentRepo commentRepo;
    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Long postId) {
        Post post=postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post not found with this is"+postId));
        Comment comment= modelMapper.map(commentDto,Comment.class);
        comment.setPost(post);
        Comment savedComment=commentRepo.save(comment);
        return modelMapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Long commentId) {
         commentRepo.deleteById(commentId);
    }
}
