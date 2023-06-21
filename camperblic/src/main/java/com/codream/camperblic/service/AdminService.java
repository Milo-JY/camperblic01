package com.codream.camperblic.service;

import com.codream.camperblic.domain.community.Campstory;
import com.codream.camperblic.domain.community.Freeboard;
import com.codream.camperblic.domain.community.Gathercamper;
import com.codream.camperblic.domain.community.Reviewcamping;
import com.codream.camperblic.domain.item.*;
import com.codream.camperblic.domain.login.Member;
import com.codream.camperblic.domain.payment.GraphDTO;

import com.codream.camperblic.domain.payment.GraphDTO;
import com.codream.camperblic.domain.payment.Orders;
import com.codream.camperblic.repository.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Cook> adminfindcookfive(){
        return adminRepository.adminFindCookFive();
    }

    public List<Etc> adminfindetcfive(){
        return adminRepository.adminFindEtcFive();
    }

    public List<Mat> adminfindmatfive(){
        return adminRepository.adminFindMatFive();
    }

    public List<Chair> adminfindchairfive(){
        return adminRepository.adminFindChairFive();
    }

    public List<Tent> adminfindtentfive(){
        return adminRepository.adminFindTentFive();
    }

    public List<Campstory> adminfindcamppostingsfive(){
        return adminRepository.adminFindCampPostingsFive();
    }

    public List<Freeboard> adminfindfreepostingsfive(){
        return adminRepository.adminFindFreePostingsFive();
    }

    public List<Gathercamper> adminfindgatherpostingsfive(){
        return adminRepository.adminFindGatherPostingsFive();
    }

    public List<Reviewcamping> adminfindreviewpostingsfive(){
        return adminRepository.adminFindReviewPostingsFive();
    }

    public List<Campstory> adminfindcamppostings(){
        return adminRepository.adminFindCampPostings();
    }

    public List<Freeboard> adminfindfreepostings(){
        return adminRepository.adminFindFreePostings();
    }

    public List<Gathercamper> adminfindgatherpostings(){
        return adminRepository.adminFindGatherPostings();
    }

    public List<Reviewcamping> adminfindreviewpostings(){
        return adminRepository.adminFindReviewPostings();
    }

    public List<Member> adminmemberlist(){
        return adminRepository.adminMemberList();
    }

    public List<Cook> admincookstock(){
        return adminRepository.adminCookStock();
    }

    public List<Etc> adminetcstock(){
        return adminRepository.adminEtcStock();
    }

    public List<Mat> adminmatstock(){
        return adminRepository.adminMatStock();
    }

    public List<Chair> adminchairstock(){
        return adminRepository.adminChairStock();
    }

    public List<Tent> admintentstock(){
        return adminRepository.adminTentStock();
    }

    public List<Tent> admintotalTent() { return adminRepository.adminTotalPriceTent();}

    public List<Chair> admintotalChair() { return adminRepository.adminTotalPriceChair();}

    public List<Mat> admintotalMat() { return adminRepository.adminTotalPriceMat();}

    public List<Cook> admintotalCook() { return adminRepository.adminTotalPriceCook();}

    public List<Etc> admintotalEtc() { return adminRepository.adminTotalPriceEtc();}




    public List<Orders> admintotalAll() {return adminRepository.findAll();}


    public List<Orders> paymentfinish(){return adminRepository.paymentFinish();} // 결제완료

    public List<Orders> delivery(){return adminRepository.delivery();} // 배송중

    public List<Orders> allfinish(){return adminRepository.allFinish();} // 배송완료


    public GraphDTO graphservice(){return adminRepository.graph();}


}