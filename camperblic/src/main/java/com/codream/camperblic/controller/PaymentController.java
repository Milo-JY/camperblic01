package com.codream.camperblic.controller;

import com.codream.camperblic.domain.payment.Cart;
import com.codream.camperblic.service.PaymentService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class PaymentController {

    private final PaymentService paymentService;
    private final JwtUtil jwtUtil;
    @Autowired
    public PaymentController(com.codream.camperblic.service.PaymentService paymentService, com.codream.camperblic.controller.JwtUtil jwtUtil) {
        this.paymentService = paymentService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/cart")
    public ResponseEntity<List<Cart>> getCartByUserId(@org.springframework.web.bind.annotation.CookieValue(value = "token", required = false) String token) {
        if (!jwtUtil.validateToken(token)) {
            return ResponseEntity.status(org.springframework.http.HttpStatus.UNAUTHORIZED).body(null);
        }
        String userid = jwtUtil.getUseridFromToken(token);
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
