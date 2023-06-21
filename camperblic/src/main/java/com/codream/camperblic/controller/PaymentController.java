package com.codream.camperblic.controller;

import com.codream.camperblic.domain.payment.Cart;
import com.codream.camperblic.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/cart")
    public ResponseEntity<List<Cart>> getCartByUserId(@RequestParam String userid) {
        List<Cart> cartList = paymentService.findByCartList(userid);

        if (!cartList.isEmpty()) {
            return ResponseEntity.ok(cartList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/cart")
//    public Integer itemTotalCount(@RequestParam String userid) {
//        Integer cartItemTotalCount = paymentService.sumTotalItemCount(userid);
//
//        if (!cartItemTotalCount.equals(null)) {
//            return cartItemTotalCount;
//        } else {
//            return 000;
//        }
//    }


}
