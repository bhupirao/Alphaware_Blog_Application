package com.alphaware.Service.Impl;

import com.alphaware.Model.Feed;
import com.alphaware.Repository.FeedRepo;
import com.alphaware.Service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    private FeedRepo feedRepo;


    @Override
    public List<Feed> getPostsForCurrentDay() {
        LocalDate currentDate = LocalDate.now();
        return feedRepo.findByDate(currentDate);
    }
}
