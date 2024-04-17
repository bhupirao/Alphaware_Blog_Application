package com.alphaware.Controller;

import com.alphaware.Model.Feed;
import com.alphaware.Service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/feed")
public class FeedController {


    @Autowired
    private FeedService feedService;

    @GetMapping("/")
    public ResponseEntity<List<Feed>> getPostsForCurrentDay() {
        List<Feed> posts = feedService.getPostsForCurrentDay();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


}
