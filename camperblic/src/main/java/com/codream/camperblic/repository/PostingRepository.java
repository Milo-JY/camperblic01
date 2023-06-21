package com.codream.camperblic.repository;

import com.codream.camperblic.domain.community.Campstory;
import com.codream.camperblic.domain.community.Freeboard;
import com.codream.camperblic.domain.community.Gathercamper;
import com.codream.camperblic.domain.community.Reviewcamping;

import java.util.List;

public interface PostingRepository {

    List<Campstory> findCampPostings();
    List<Freeboard> findFreePostings();
    List<Gathercamper> findGatherPostings();
    List<Reviewcamping> findReviewPostings();


    Campstory findCampPostingById(Long id);

    Freeboard findFreePostingById(Long id);

    Gathercamper findGatherPostingById(Long id);

    Reviewcamping findReviewPostingById(Long id);
}
