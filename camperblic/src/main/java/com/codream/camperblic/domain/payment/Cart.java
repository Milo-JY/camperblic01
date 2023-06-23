package com.codream.camperblic.domain.payment;

import com.codream.camperblic.domain.login.Member;
import jakarta.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartid")
    private int cartid;

    private String userid;  // 로그인 확인 된 회원ID


    private String itemid;

    private int itemcount;  // 카트에 담긴 상품 개수

    @Column(name = "category_id")
    private String category_id;

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


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
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

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }
}
