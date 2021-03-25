package com.boot.elk.logaggregation.post.service;

import com.boot.elk.logaggregation.post.domain.Post;
import com.boot.elk.logaggregation.post.domain.PostWithComments;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getPosts();

    Optional<PostWithComments> getPost(Long id);
}
