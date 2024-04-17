package com.alphaware.Service;

import com.alphaware.Model.Feed;

import java.util.List;

public interface FeedService {

    public List<Feed> getPostsForCurrentDay();
}
