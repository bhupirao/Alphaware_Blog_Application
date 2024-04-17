package com.alphaware.Repository;

import com.alphaware.Model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FeedRepo extends JpaRepository<Feed,Integer> {

    List<Feed> findByDate(LocalDate date);


}
