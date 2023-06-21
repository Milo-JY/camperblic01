package com.codream.camperblic.controller;

import com.codream.camperblic.domain.community.Campstory;
import com.codream.camperblic.domain.community.Freeboard;
import com.codream.camperblic.domain.community.Gathercamper;
import com.codream.camperblic.domain.community.Reviewcamping;
import com.codream.camperblic.domain.item.*;
import com.codream.camperblic.service.ItemService;
import com.codream.camperblic.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private PostingService postingService;

    @Autowired
    public MainController(PostingService postingService) {
        this.postingService = postingService;
    }

    // 민수 컨트롤러
    @GetMapping("/campstory")
    public List<Campstory> campstory() {
        return postingService.findCampPostings();
    }

    @GetMapping("/freeboard")
    public List<Freeboard> freeboard() {
        return postingService.findFreePostings();
    }

    @GetMapping("/gathercamper")
    public List<Gathercamper> gathercamper() {
        return postingService.findGatherPostings();
    }

    @GetMapping("/reviewcampingsite")
    public List<Reviewcamping> reviewcampingsite() {
        return postingService.findReviewPostings();
    }

    @GetMapping("/boarddetail/{category}/{id}")
    public Object getPostingDetail(@PathVariable("category") String category, @PathVariable("id") Long id) {
        Object postingDetail = null;

        if (category.equals("campstory")) {
            postingDetail = postingService.findCampPostingDetail(id);
        } else if (category.equals("freeboard")) {
            postingDetail = postingService.findFreePostingDetail(id);
        } else if (category.equals("gathercamper")) {
            postingDetail = postingService.findGatherPostingDetail(id);
        } else if (category.equals("reviewcamping")) {
            postingDetail = postingService.findReviewPostingDetail(id);
        }

        return postingDetail;
    }// 민수 컨트롤러 끝
}
