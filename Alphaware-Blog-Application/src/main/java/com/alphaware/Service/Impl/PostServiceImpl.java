package com.alphaware.Service.Impl;

import com.alphaware.Exception.CategoryException;
import com.alphaware.Exception.PostException;
import com.alphaware.Exception.UserException;
import com.alphaware.Model.Category;
import com.alphaware.Model.Post;
import com.alphaware.Model.User;
import com.alphaware.Repository.CategoryRepo;
import com.alphaware.Repository.PostRepo;
import com.alphaware.Repository.UserRepo;
import com.alphaware.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Post createPost(Post post, Integer userId,Integer categoryId) throws UserException, CategoryException {
        User userOpt=userRepo.findById(userId).orElseThrow(()->new UserException("id not found"));
        Category catOpt=categoryRepo.findById(categoryId).orElseThrow(()->new CategoryException("id not found"));


         Post post1=new Post();
         post1.setTitle(post.getTitle());
         post1.setContent(post.getContent());
         post1.setImage(post.getImage());
         post1.setDateTime(post.getDateTime().now());
         post1.setUser(userOpt);
         post1.setCategories((List<Category>) catOpt);

         return postRepo.save(post1);


    }

    @Override
    public Post getPostById(Integer postId) throws PostException {

        Optional<Post> opt=postRepo.findById(postId);

        if(opt.isPresent()){
            return opt.get();
        }throw new PostException("PostId not found!");
    }

    @Override
    public Post updatePost(Integer postId, Post postDetails) throws PostException {
        Optional<Post> opt=postRepo.findById(postId);

        if(opt.isPresent()){
            Post post =opt.get();
            post.setTitle(postDetails.getTitle());
            post.setContent(postDetails.getContent());
            post.setImage(postDetails.getImage());
            post.setDateTime(postDetails.getDateTime().now());

            return postRepo.save(post);
        }throw new PostException("PostId not found!");

    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public void deletePost(Integer postId) throws PostException {

        Optional<Post> opt=postRepo.findById(postId);

        if(opt.isPresent()){
            postRepo.delete(opt.get());
            return;
        }throw new PostException("PostId not found!");
    }
}
