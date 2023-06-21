package com.codream.camperblic.service;


import com.codream.camperblic.domain.payment.Cart;
import com.codream.camperblic.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class PaymentService {

    @Autowired
    CartRepository cartRepository;

    public List<Cart> findByCartList(String userid) {
        return cartRepository.findByCartList(userid);
    }

    public Cart addCart(Cart cart) { return cartRepository.save(cart); }

    public Integer sumTotalItemCount(String userid) { return cartRepository.cartTotalCountByUserId(userid);}

}
