package com.codream.camperblic.repository;

import com.codream.camperblic.domain.payment.Cart;

import java.util.List;

public interface CartRepository {

    List<Cart> findAllByCartList(String userid);

    Cart save(Cart cart);


    Integer cartTotalCountByUserId(String userid);
}
