package com.alphaware.Service.Impl;

import com.alphaware.Exception.CommentException;
import com.alphaware.Exception.PostException;
import com.alphaware.Exception.UserException;
import com.alphaware.Model.Comment;
import com.alphaware.Model.Post;
import com.alphaware.Model.User;
import com.alphaware.Repository.CommentRepo;
import com.alphaware.Repository.PostRepo;
import com.alphaware.Repository.UserRepo;
import com.alphaware.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;



    @Override
    public Comment createComment(Comment comment, Integer userId, Integer postId) throws UserException, PostException {
        User user = userRepo.findById(userId).orElseThrow(() -> new UserException("UserId not found"));
        Post post = postRepo.findById(postId).orElseThrow(() -> new PostException("PostId not found"));

        comment.setUser(user);
        comment.setPost(post);
        comment.setDateTime(comment.getDateTime().now());

        return commentRepo.save(comment);
    }

    @Override
    public Comment getCommentById(Integer commentId) throws CommentException {
        Optional<Comment> opt=commentRepo.findById(commentId);

        if(opt.isPresent()){
            return opt.get();
        }throw new CommentException("CommentId not found!");
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public Comment updateComment(Integer commentId, Comment commentDetails) throws CommentException {
        Optional<Comment> opt=commentRepo.findById(commentId);

        if(opt.isPresent()){
            Comment comment=opt.get();
            comment.setComment(commentDetails.getComment());
            comment.setDateTime(commentDetails.getDateTime().now());
            return commentRepo.save(comment);
        }throw new CommentException("CommentId not found!");
    }

    @Override
    public void deleteComment(Integer commentId) throws CommentException {

        Optional<Comment> opt=commentRepo.findById(commentId);

        if(opt.isPresent()){
            commentRepo.delete(opt.get());
            return ;
        }throw new CommentException("CommentId not found!");
    }
}
