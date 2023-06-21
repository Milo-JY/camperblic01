package com.codream.camperblic.controller;

import com.codream.camperblic.domain.item.*;
//import com.codream.camperblic.repository.CartRepository;
import com.codream.camperblic.service.ItemService;
//import com.codream.camperblic.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    private ItemService itemService;
//    private CartRepository cartRepository;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;

    }

    // 신준이 컨트롤러

//    @PostMapping("/cart")
//    public void addToCart(@RequestBody Item item) {
//        // Item 객체를 Cart 객체로 변환하여 Cart 테이블에 저장
//        Cart cart = new Cart();
//        cart.setUserid(getLoggedInUser()); // 로그인한 회원의 정보 설정
//        cart.setItemid(item.getItemId()); // 상품 ID 설정
//        cart.setItemcount(1); // 상품 개수 설정
//        cartRepository.save(cart);
//    }


    @GetMapping("/cook")
    public List<Cook> cooks() {
        return itemService.findCooks();
    }

    @GetMapping("/etc")
    public List<Etc> etc() {
        return itemService.findEtc();
    }

    @GetMapping("/mat")
    public List<Mat> mat() {
        return itemService.findMat();
    }

    @GetMapping("/chair")
    public List<Chair> chair() {
        return itemService.findChair();
    }

    @GetMapping("/tent")
    public List<Tent> tent() {
        return itemService.findTent();
    }

    @GetMapping("/itemdetail/{categoryId}/{itemId}")
    public Object getItemDetail(@PathVariable("categoryId") String categoryId, @PathVariable("itemId") String itemId) {
        Object itemDetail = null;

        if (categoryId.equals("cook")) {
            itemDetail = itemService.findCookDetail(itemId);
        } else if (categoryId.equals("mat")) {
            itemDetail = itemService.findMatDetail(itemId);
        } else if (categoryId.equals("etc")) {
            itemDetail = itemService.findEtcDetail(itemId);
        } else if (categoryId.equals("chair")) {
            itemDetail = itemService.findChairDetail(itemId);
        } else if (categoryId.equals("tent")) {
            itemDetail = itemService.findTentDetail(itemId);
        }

        return itemDetail;
    }

    // 신준이 컨트롤러 끝
}
