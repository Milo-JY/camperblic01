package com.codream.camperblic.repository;

import com.codream.camperblic.domain.payment.Cart;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class JpaCartRepository implements CartRepository{

    @PersistenceContext
    private EntityManager em;

    public JpaCartRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Cart> findAllByCartList(String userid) {
        return em.createQuery("SELECT c FROM Cart c WHERE c.userid = :userid", Cart.class)
                .setParameter("userid", userid).getResultList();

    }

    @Override
    public Cart save(Cart cart) {
        em.persist(cart);
        return cart;
    }

    @Override
    public Integer cartTotalCountByUserId(String userid) {
        TypedQuery<Integer> sumCount = em.createQuery("SELECT SUM(c.itemcount) FROM Cart c WHERE c.userid = :userid", Integer.class)
                .setParameter("userid", userid);
        return sumCount.getSingleResult();
    }
    // 검색 조건 : 동일한 memberid, itemcount 합계 (합계는


}
