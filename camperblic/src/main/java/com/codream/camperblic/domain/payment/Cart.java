package com.codream.camperblic.domain.payment;

import com.codream.camperblic.domain.login.Member;
import jakarta.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartid")
    private int cartid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private Member userid;  // 로그인 확인 된 회원ID


    private String itemid;

    private int itemcount;  // 카트에 담긴 상품 개수

    public Cart() {

    }

    public Cart(String itemid, int itemcount) {

    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public Member getUserid() {
        return userid;
    }

    public void setUserid(Member userid) {
        this.userid = userid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public int getItemcount() {
        return itemcount;
    }

    public void setItemcount(int itemcount) {
        this.itemcount = itemcount;
    }


}
