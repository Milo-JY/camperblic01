package com.codream.camperblic.controller;

import com.codream.camperblic.domain.community.Campstory;
import com.codream.camperblic.domain.community.Freeboard;
import com.codream.camperblic.domain.community.Gathercamper;
import com.codream.camperblic.domain.community.Reviewcamping;
import com.codream.camperblic.domain.item.*;
import com.codream.camperblic.domain.login.Member;
import com.codream.camperblic.domain.payment.GraphDTO;
import com.codream.camperblic.domain.payment.Orders;
import com.codream.camperblic.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admindashboard/admindashboardstockcook")
    public List<Cook> admincookFive(){
        return adminService.adminfindcookfive();
    }

    @GetMapping("/admindashboard/admindashboardstocktent")
    public List<Tent> admintentFive(){
        return adminService.adminfindtentfive();
    }

    @GetMapping("/admindashboard/admindashboardstockchair")
    public List<Chair> adminchairFive(){
        return adminService.adminfindchairfive();
    }

    @GetMapping("/admindashboard/admindashboardstockmat")
    public List<Mat> adminmatFive(){
        return adminService.adminfindmatfive();
    }

    @GetMapping("/admindashboard/admindashboardstocketc")
    public List<Etc> adminetcFive(){
        return adminService.adminfindetcfive();
    }

    @GetMapping("/admindashboard/admindashboardboardcampstory")
    public List<Campstory> admincampFive(){ return adminService.adminfindcamppostingsfive(); }

    @GetMapping("/admindashboard/admindashboardboardfreeboard")
    public List<Freeboard> adminFreeFive(){ return adminService.adminfindfreepostingsfive(); }

    @GetMapping("/admindashboard/admindashboardboardgathercamper")
    public List<Gathercamper> adminGatherFive(){ return adminService.adminfindgatherpostingsfive();}

    @GetMapping("/admindashboard/admindashboardboardreview")
    public List<Reviewcamping> adminReviewFive(){ return adminService.adminfindreviewpostingsfive();}

    @GetMapping("/adminboard/adminboardcampstory")
    public List<Campstory> admincampList() { return adminService.adminfindcamppostings();}

    @GetMapping("/adminboard/adminboardfreeboard")
    public List<Freeboard> adminfreeList() { return adminService.adminfindfreepostings();}

    @GetMapping("/adminboard/adminboardgathercamper")
    public List<Gathercamper> adminfgatherList() { return adminService.adminfindgatherpostings();}

    @GetMapping("/adminboard/adminboardreview")
    public List<Reviewcamping> adminreviewList() { return adminService.adminfindreviewpostings();}

    @GetMapping("/adminstock/tent")
    public List<Tent> admintentList() {return adminService.admintentstock();}

    @GetMapping("/adminstock/chair")
    public List<Chair> adminchairList() { return adminService.adminchairstock();}

    @GetMapping("/adminstock/mat")
    public List<Mat> adminmatList() {return adminService.adminmatstock();}

    @GetMapping("/adminstock/cook")
    public List<Cook> admincookList() { return adminService.admincookstock();}

    @GetMapping("/adminstock/etc")
    public List<Etc> adminetcList() { return adminService.adminetcstock();}

    @GetMapping("/adminmember")
    public List<Member> adminmemberList() { return adminService.adminmemberlist();}

    @GetMapping("/admindashboard")
    public List<Tent> adminTotalTent() { return  adminService.admintotalTent();}
//
//    @GetMapping("/admindashboard")
//    public List<Chair> adminTotalChair() {return adminService.admintotalChair();}

    @GetMapping("/admindashboard/admindashboardchart")
    public GraphDTO getAdminDashboardData() {
        return adminService.graphservice();
    }

    @GetMapping("/admindashboard/orderpayment")
    public List<Orders> adminorderPayment(){return adminService.paymentfinish();}

    @GetMapping("/admindashboard/orderdelivery")
    public List<Orders> adminorderDelivery() {return adminService.delivery();}

    @GetMapping("/admindashboard/orderallfinish")
    public List<Orders> adminorderAllfinish() {return adminService.allfinish();}

}