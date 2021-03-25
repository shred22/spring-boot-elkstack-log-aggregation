package com.boot.elk.logaggregation.post.web.controller;

import com.boot.elk.logaggregation.post.domain.Post;
import com.boot.elk.logaggregation.post.domain.PostWithComments;
import com.boot.elk.logaggregation.post.web.exception.ResourceNotFoundException;
import com.boot.elk.logaggregation.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = service.getPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostWithComments> getPost(@PathVariable Long id) {
        PostWithComments postWithComments = service.getPost(id).orElseThrow(
            ResourceNotFoundException::new);
        return ResponseEntity.ok(postWithComments);
    }
}
