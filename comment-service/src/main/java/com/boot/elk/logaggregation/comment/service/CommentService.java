package com.boot.elk.logaggregation.comment.service;

import com.boot.elk.logaggregation.comment.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentsForPost(Long postId);
}
