package com.codream.camperblic.repository;

import com.codream.camperblic.domain.community.Campstory;
import com.codream.camperblic.domain.community.Freeboard;
import com.codream.camperblic.domain.community.Gathercamper;
import com.codream.camperblic.domain.community.Reviewcamping;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class JpaPostingRepository implements PostingRepository{

    private final EntityManager em;

    public JpaPostingRepository(EntityManager em) {
        this.em = em;
    }

//  findAll 메서드
    @Override
    public List<Campstory> findCampPostings() {
        return em.createQuery("select p from Campstory p ORDER BY p.id DESC", Campstory.class)
                .getResultList();
    }

    @Override
    public List<Freeboard> findFreePostings() {
        return em.createQuery("select p from Freeboard p ORDER BY p.id DESC", Freeboard.class)
                .getResultList();
    }

    @Override
    public List<Gathercamper> findGatherPostings() {
        return em.createQuery("select p from Gathercamper p ORDER BY p.id DESC", Gathercamper.class)
                .getResultList();
    }

    @Override
    public List<Reviewcamping> findReviewPostings() {
        return em.createQuery("select p from Reviewcamping p ORDER BY p.id DESC", Reviewcamping.class)
                .getResultList();
    }// findAll 메서드 끝


    @Override
    public Campstory findCampPostingById(Long id) {
        return em.find(Campstory.class, id);
    }

    @Override
    public Freeboard findFreePostingById(Long id) {
        return em.find(Freeboard.class, id);
    }

    @Override
    public Gathercamper findGatherPostingById(Long id) {
        return em.find(Gathercamper.class, id);
    }

    @Override
    public Reviewcamping findReviewPostingById(Long id) {
        return em.find(Reviewcamping.class, id);
    }
}
