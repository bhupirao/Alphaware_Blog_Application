package com.alphaware.Service;

import com.alphaware.Exception.CommentException;
import com.alphaware.Exception.PostException;
import com.alphaware.Exception.UserException;
import com.alphaware.Model.Comment;

import java.util.List;

public interface CommentService {

    public Comment createComment(Comment comment, Integer userId, Integer postId)throws UserException, PostException;
    public Comment getCommentById(Integer commentId)throws CommentException;
    public List<Comment> getAllComments();
    public Comment updateComment(Integer commentId, Comment commentDetails)throws CommentException;
    public void deleteComment(Integer commentId)throws CommentException;
}
