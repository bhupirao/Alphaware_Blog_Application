package com.alphaware.Controller;

import com.alphaware.Exception.CategoryException;
import com.alphaware.Exception.PostException;
import com.alphaware.Exception.UserException;
import com.alphaware.Model.Post;
import com.alphaware.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/createPost/{userId}/{categoryId}")
    public ResponseEntity<Post> createPostHandler(@RequestBody Post post, @PathVariable Integer userId,@PathVariable Integer categoryId) throws UserException, CategoryException {
        Post post1 = postService.createPost(post, userId,categoryId);
        return new ResponseEntity<>(post1, HttpStatus.CREATED);
    }


    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostByIdHandler(@PathVariable Integer postId)throws PostException {

        Post post = postService.getPostById(postId);

        return new ResponseEntity<>(post, HttpStatus.OK);

    }

    @PatchMapping("/{postId}")
    public ResponseEntity<Post> updatePostHandler(@PathVariable Integer postId, @RequestBody Post postDetails)throws PostException {
        Post updatedPost = postService.updatePost(postId, postDetails);

        return new ResponseEntity<>(updatedPost, HttpStatus.OK);

    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePostHandler(@PathVariable Integer postId)throws PostException {
        postService.deletePost(postId);

        return new ResponseEntity<>(HttpStatus.OK);

    }



}
