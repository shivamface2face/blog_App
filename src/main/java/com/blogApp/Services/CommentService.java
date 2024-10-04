package com.blogApp.Services;

import com.blogApp.paylods.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,Long postId);
    void deleteComment(Long commentId);
}
