package com.alphaware.Controller;


import com.alphaware.Exception.CommentException;
import com.alphaware.Exception.PostException;
import com.alphaware.Exception.UserException;
import com.alphaware.Model.Comment;
import com.alphaware.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {



    @Autowired
    private CommentService commentService;

    @PostMapping("/createComm")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment, @RequestParam Integer userId, @RequestParam Integer postId)throws UserException, PostException {
        Comment createdComment = commentService.createComment(comment, userId, postId);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }


    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer commentId)throws CommentException {
        Comment comment = commentService.getCommentById(commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }


    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Integer commentId,@RequestBody Comment commentDetails)throws CommentException {
        Comment updatedComment = commentService.updateComment(commentId, commentDetails);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }


    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer commentId)throws CommentException {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
