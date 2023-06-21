package com.codream.camperblic.service;

import com.codream.camperblic.domain.community.Campstory;
import com.codream.camperblic.domain.community.Freeboard;
import com.codream.camperblic.domain.community.Gathercamper;
import com.codream.camperblic.domain.community.Reviewcamping;
import com.codream.camperblic.repository.PostingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostingService {

    private final PostingRepository postingRepository;

    public PostingService(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;
    }

    public List<Campstory> findCampPostings() {
        return postingRepository.findCampPostings();
    }

    public List<Freeboard> findFreePostings() {
        return postingRepository.findFreePostings();
    }

    public List<Gathercamper> findGatherPostings() {
        return postingRepository.findGatherPostings();
    }

    public List<Reviewcamping> findReviewPostings() {
        return postingRepository.findReviewPostings();
    }

    public Campstory findCampPostingDetail(Long id) {
        return postingRepository.findCampPostingById(id);
    }

    public Freeboard findFreePostingDetail(Long id) {
        return postingRepository.findFreePostingById(id);
    }

    public Gathercamper findGatherPostingDetail(Long id) {
        return postingRepository.findGatherPostingById(id);
    }

    public Reviewcamping findReviewPostingDetail(Long id) {
        return postingRepository.findReviewPostingById(id);
    }
}
