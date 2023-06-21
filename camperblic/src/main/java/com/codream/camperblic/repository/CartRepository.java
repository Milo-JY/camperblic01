package com.codream.camperblic.repository;

import com.codream.camperblic.domain.payment.Cart;

import java.util.List;

public interface CartRepository {

    List<Cart> findByCartList(String memberid);

    Cart save(Cart cart);


    Integer cartTotalCountByUserId(String userid);
}
