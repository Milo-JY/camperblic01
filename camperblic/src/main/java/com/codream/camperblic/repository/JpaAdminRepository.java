package com.codream.camperblic.repository;

import com.codream.camperblic.domain.community.Campstory;
import com.codream.camperblic.domain.community.Freeboard;
import com.codream.camperblic.domain.community.Gathercamper;
import com.codream.camperblic.domain.community.Reviewcamping;
import com.codream.camperblic.domain.item.*;
import com.codream.camperblic.domain.login.Member;

import com.codream.camperblic.domain.payment.GraphDTO;
import com.codream.camperblic.domain.payment.Orders;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class JpaAdminRepository implements AdminRepository {

    private final EntityManager em;

    public JpaAdminRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Cook> adminFindCookFive() { // 대시보드에서 cook 5개
        return em.createQuery("SELECT c FROM Cook c ORDER BY c.current_stock ASC",Cook.class)
                .setMaxResults(5)
                .getResultList();
    }

    @Override
    public List<Etc> adminFindEtcFive() { // 대시보드에서 etc 5개
        return em.createQuery("SELECT a FROM Etc a ORDER BY a.current_stock ASC",Etc.class)
                .setMaxResults(5)
                .getResultList();
    }

    @Override
    public List<Mat> adminFindMatFive() { // 대시보드에서 mat 5개
        return em.createQuery("SELECT b FROM Mat b ORDER BY b.current_stock ASC",Mat.class)
                .setMaxResults(5)
                .getResultList();
    }

    @Override
    public List<Chair> adminFindChairFive() { // 대시보드에서 chair 5개
        return em.createQuery("SELECT d FROM Chair d ORDER BY d.current_stock ASC",Chair.class)
                .setMaxResults(5)
                .getResultList();
    }

    @Override
    public List<Tent> adminFindTentFive() { // 대시보드에서 tent 5개
        return em.createQuery("SELECT e FROM Tent e ORDER BY e.current_stock ASC",Tent.class)
                .setMaxResults(5)
                .getResultList();
    }

    @Override
    public List<Campstory> adminFindCampPostingsFive() { // 대시보드에서 캠핑이야기 5개
        return em.createQuery("SELECT c FROM Campstory c ORDER BY createdate DESC",Campstory.class)
                .setMaxResults(5)
                .getResultList();
    }

    @Override
    public List<Freeboard> adminFindFreePostingsFive() { // 대시보드에서 자유게시판 5개
        return em.createQuery("SELECT a FROM Freeboard a ORDER BY createdate DESC",Freeboard.class)
                .setMaxResults(5)
                .getResultList();
    }

    @Override
    public List<Gathercamper> adminFindGatherPostingsFive() { // 대시보드에서 캠퍼구인 5개
        return em.createQuery("SELECT g FROM Gathercamper g ORDER BY createdate DESC",Gathercamper.class)
                .setMaxResults(5)
                .getResultList();
    }

    @Override
    public List<Reviewcamping> adminFindReviewPostingsFive() { // 대시보드에서 캠핑장후기 5개
        return em.createQuery("SELECT r FROM Reviewcamping r ORDER BY createdate DESC",Reviewcamping.class)
                .setMaxResults(5)
                .getResultList();
    }

    @Override
    public List<Campstory> adminFindCampPostings() { // 관리게시판에서 캠핑이야기전체출력
        return em.createQuery("select p from Campstory p ORDER BY p.id DESC", Campstory.class)
                .getResultList();
    }

    @Override
    public List<Freeboard> adminFindFreePostings() { // 관리게시판에서 자유게시판 전체출력
        return em.createQuery("select p from Freeboard p ORDER BY p.id DESC", Freeboard.class)
                .getResultList();
    }

    @Override
    public List<Gathercamper> adminFindGatherPostings() { // 관리게시판에서 캠퍼구인 전체출력
        return em.createQuery("select p from Gathercamper p ORDER BY p.id DESC", Gathercamper.class)
                .getResultList();
    }

    @Override
    public List<Reviewcamping> adminFindReviewPostings() { // 관리게시판에서 캠핑장후기 전체출력
        return em.createQuery("select p from Reviewcamping p ORDER BY p.id DESC", Reviewcamping.class)
                .getResultList();
    }

    @Override
    public List<Member> adminMemberList() { // 회원관리에서 리스트 출력
        return em.createQuery("SELECT m FROM Member m ORDER BY m.userid ASC",Member.class)
                .getResultList();
    }

    @Override
    public List<Cook> adminCookStock() { // 재고관리에서 cook인 재고리스트출력
        return em.createQuery("SELECT c FROM Cook c ORDER BY current_stock ASC",Cook.class)
                .getResultList();
    }

    @Override
    public List<Etc> adminEtcStock() { // 재고관리에서 etc인 재고리스트출력
        return em.createQuery("SELECT e FROM Etc e ORDER BY current_stock ASC",Etc.class)
                .getResultList();
    }

    @Override
    public List<Mat> adminMatStock() { // 재고관리에서 침낭/매트 재고리스트출력
        return em.createQuery("SELECT m FROM Mat m ORDER BY current_stock ASC",Mat.class)
                .getResultList();
    }

    @Override
    public List<Chair> adminChairStock() { // 재고관리에서 테이블/의자 재고리스트 출력
        return em.createQuery("SELECT a FROM Chair a ORDER BY current_stock ASC",Chair.class)
                .getResultList();
    }

    @Override
    public List<Tent> adminTentStock() { // 재고관리에서 텐트/타프 리스트 출력
        return em.createQuery("SELECT t FROM Tent t ORDER BY current_stock ASC",Tent.class)
                .getResultList();
    }

    //텐트하는거 예시
    @Override
    public List<Tent> adminTotalPriceTent() {
        return em.createQuery("SELECT SUM(o.price) as tentSum FROM Tent o", Tent.class)
                .getResultList();
    }

    @Override
    public List<Chair> adminTotalPriceChair() {
        return em.createQuery("SELECT SUM(o.price) as chairSum FROM Chair o", Chair.class)
                .getResultList();
    }

    @Override
    public List<Mat> adminTotalPriceMat() {
        return em.createQuery("SELECT SUM(o.price) as matSum FROM Mat o", Mat.class)
                .getResultList();
    }

    @Override
    public List<Cook> adminTotalPriceCook() {
        return em.createQuery("SELECT SUM(o.price) as cookSum FROM Cook o", Cook.class)
                .getResultList();
    }

    @Override
    public List<Etc> adminTotalPriceEtc() {
        return em.createQuery("SELECT SUM(o.price) as etcSum FROM Etc o", Etc.class)
                .getResultList();
    }

    @Override
//    @Query(value = "SELECT o.orderCategory, SUM(o.orderPrice) FROM tmp o WHERE o.deliveryStatus = '배송완료' GROUP BY o.orderCategory", nativeQuery = true)
    public List<Object[]> calculateCategoryOrderPrice(){
        return null;
    }

    @Override
//    @Query(value = "SELECT SUM(o.orderPrice) FROM tmp o WHERE o.deliveryStatus = '배송완료'", nativeQuery = true)
    public Long calculateTotalOrderPrice() {
//        return em.createQuery("SELECT o.orderCategory, SUM(o.orderPrice) FROM tmp o WHERE o.deliveryStatus = '배송완료' GROUP BY o.orderCategory")
//                .getResultList();
        return null;
    }

    @Override
    public List<Orders> findAll() {
        return null;
    }

    @Override
    public GraphDTO graph() {
        int tentTotalPrice = getTentTotalPrice();
        int chairTotalPrice = getChairTotalPrice();
        int matTotalPrice = getMatTotalPrice();
        int cookTotalPrice = getCookTotalPrice();
        int etcTotalPrice = getEtcTotalPrice();
        int totalPriceSum = tentTotalPrice+chairTotalPrice+matTotalPrice+cookTotalPrice+etcTotalPrice;

        return new GraphDTO(tentTotalPrice, chairTotalPrice, matTotalPrice, cookTotalPrice, etcTotalPrice, totalPriceSum);
    }
    // Get method for the total delivery cost
    private int getTentTotalPrice() {
        Query query = em.createQuery("SELECT SUM(o.deliverycost) FROM Orders o " +
                "JOIN Tent t ON o.orderid = t.item_id " +
                "WHERE o.orderstatus = '배송완료' AND t.category_id = 'a'");
        Long totalDeliveryCost = (Long) query.getSingleResult();
        Integer totalDeliveryCostInt = totalDeliveryCost != null ? totalDeliveryCost.intValue() : 0;
        return totalDeliveryCostInt;
    }


    private int getChairTotalPrice() {
        Query query = em.createQuery("SELECT SUM(o.deliverycost) FROM Orders o " +
                "JOIN Tent t ON o.orderid = t.item_id " +
                "WHERE o.orderstatus = '배송완료' AND t.category_id = 'b'");
        Long totalDeliveryCost = (Long) query.getSingleResult();
        Integer totalDeliveryCostInt = totalDeliveryCost != null ? totalDeliveryCost.intValue() : 0;
        return totalDeliveryCostInt;

    }

    private int getMatTotalPrice() {
        Query query = em.createQuery("SELECT SUM(o.deliverycost) FROM Orders o " +
                "JOIN Tent t ON o.orderid = t.item_id " +
                "WHERE o.orderstatus = '배송완료' AND t.category_id = 'c'");
        Long totalDeliveryCost = (Long) query.getSingleResult();
        Integer totalDeliveryCostInt = totalDeliveryCost != null ? totalDeliveryCost.intValue() : 0;
        return totalDeliveryCostInt;
    }

    private int getCookTotalPrice() {
        Query query = em.createQuery("SELECT SUM(o.deliverycost) FROM Orders o " +
                "JOIN Tent t ON o.orderid = t.item_id " +
                "WHERE o.orderstatus = '배송완료' AND t.category_id = 'd'");
        Long totalDeliveryCost = (Long) query.getSingleResult();
        Integer totalDeliveryCostInt = totalDeliveryCost != null ? totalDeliveryCost.intValue() : 0;
        return totalDeliveryCostInt;
    }

    private int getEtcTotalPrice() {
        Query query = em.createQuery("SELECT SUM(o.deliverycost) FROM Orders o " +
                "JOIN Tent t ON o.orderid = t.item_id " +
                "WHERE o.orderstatus = '배송완료' AND t.category_id = 'e'");
        Long totalDeliveryCost = (Long) query.getSingleResult();
        Integer totalDeliveryCostInt = totalDeliveryCost != null ? totalDeliveryCost.intValue() : 0;
        return totalDeliveryCostInt;
    }

//    private int getTotalPriceSum() {
//        // Implement the query for total price sum
//        // ...
//    }


    @Override
    public List<Orders> paymentFinish() {
        return em.createQuery("SELECT o FROM Orders o WHERE o.orderstatus = '결제완료'", Orders.class)
                .getResultList();
    }

    @Override
    public List<Orders> delivery() {
        return em.createQuery("SELECT i FROM Orders i WHERE i.orderstatus = '배송중'", Orders.class)
                .getResultList();
    }

    @Override
    public List<Orders> allFinish() {
        return em.createQuery("SELECT o FROM Orders o WHERE o.orderstatus = '배송완료'", Orders.class)
                .getResultList();
    }

//    @Override
//    @Query(value = "SELECT SUM(o.orderPrice) FROM tmp o WHERE o.deliveryStatus = '배송완료'", nativeQuery = true)
//    Long calculateTotalOrderPrice();
//
//    @Override
//    public List<tmp> findAll() {
//        return null;
//    }
//
//    @Query(value = "SELECT o.orderCategory, SUM(o.orderPrice) FROM tmp o WHERE o.deliveryStatus = '배송완료' GROUP BY o.orderCategory", nativeQuery = true)
//    List<Object[]> calculateCategoryOrderPrice();



}




