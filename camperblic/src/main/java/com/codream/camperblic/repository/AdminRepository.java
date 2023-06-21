package com.codream.camperblic.repository;

import com.codream.camperblic.domain.community.Campstory;
import com.codream.camperblic.domain.community.Freeboard;
import com.codream.camperblic.domain.community.Gathercamper;
import com.codream.camperblic.domain.community.Reviewcamping;
import com.codream.camperblic.domain.item.*;
import com.codream.camperblic.domain.login.Member;
import com.codream.camperblic.domain.payment.GraphDTO;
import com.codream.camperblic.domain.payment.Orders;

import java.util.List;

public interface AdminRepository {


    List<Cook> adminFindCookFive(); // 대시보드에서 cook 5개

    List<Etc> adminFindEtcFive(); // 대시보드에서 etc 5개

    List<Mat> adminFindMatFive(); // 대시보드에서 mat 5개

    List<Chair> adminFindChairFive(); // 대시보드에서 chair 5개

    List<Tent> adminFindTentFive(); // 대시보드에서 Tent 5개

    List<Campstory> adminFindCampPostingsFive(); // 대시보드에서 캠핑이야기 5개

    List<Freeboard> adminFindFreePostingsFive(); // 대시보드에서 자유게시판 5개

    List<Gathercamper> adminFindGatherPostingsFive(); // 대시보드에서 캠퍼구인 5개

    List<Reviewcamping> adminFindReviewPostingsFive(); // 대시보드에서 캠핑장후기 5개

    List<Campstory> adminFindCampPostings(); // 관리게시판 전체 출력
    List<Freeboard> adminFindFreePostings(); // 관리게시판 전체 출력
    List<Gathercamper> adminFindGatherPostings(); // 관리게시판 전체 출력
    List<Reviewcamping> adminFindReviewPostings(); // 관리게시판 전체 출력

    List<Member> adminMemberList(); // 회원관리(멤버관리)에서 리스트 출력

    List<Cook> adminCookStock(); // 재고관리에서 취사용품 리스트

    List<Etc> adminEtcStock(); // 재고관리에서 소품 리스트 출력

    List<Mat> adminMatStock(); // 재고관리에서 침낭/매트 출력

    List<Chair> adminChairStock(); // 재고관리에서 테이블/체어 출력

    List<Tent> adminTentStock(); // 재고관리에서 텐트/타프 출력

//    List<> adminAllStock();
    // 추가할것들 (주문현황에서 주문내역들)

    List<Tent> adminTotalPriceTent(); // 대시보드 텐트 총가격

    List<Chair> adminTotalPriceChair(); // 대시보드 테이블/체어 총가격

    List<Mat> adminTotalPriceMat(); // 대시보드 침낭/매트 총가격

    List<Cook> adminTotalPriceCook(); // 대시보드 취사용품 총가격

    List<Etc> adminTotalPriceEtc(); // 대시보드 소품 총가격

    List<Object[]> calculateCategoryOrderPrice();

    Long calculateTotalOrderPrice();

    List<Orders> findAll();

    public GraphDTO graph();


    // 주문현황

    //결제완료
    List<Orders> paymentFinish();
    // 배송중
    List<Orders> delivery();
    //배송완료
    List<Orders> allFinish();

}