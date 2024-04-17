package com.alphaware.Service;

import com.alphaware.Exception.CategoryException;
import com.alphaware.Exception.PostException;
import com.alphaware.Exception.UserException;
import com.alphaware.Model.Post;

import java.util.List;

public interface PostService {

    public Post createPost(Post post,Integer userId,Integer categoryId)throws UserException, CategoryException;
    public Post getPostById(Integer postId)throws PostException;
    public Post updatePost(Integer postId, Post postDetails)throws PostException;
    public List<Post> getAllPosts();
    public void deletePost(Integer postId)throws PostException;
}
