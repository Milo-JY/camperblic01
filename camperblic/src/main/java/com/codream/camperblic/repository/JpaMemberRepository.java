package com.codream.camperblic.repository;

import com.codream.camperblic.domain.login.Member;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Member> findByUserId(String userid) {
        Member member = em.createQuery("select m from Member  m where m.userid = :userid and m.useyn = 1", Member.class)
                .setParameter("userid",userid).getSingleResult();
        return Optional.ofNullable(member);
    }

    @Override
    public void save(Member member) {
        em.persist(member);
        em.flush();
    }

    @Override
    public void changepw(Member member) {
        System.out.println(member.getUserid());
        System.out.println(member.getPassword());
        em.createQuery("UPDATE Member m SET m.password = :password WHERE m.userid = :userid",Member.class)
                .setParameter("password" , member.getPassword()).setParameter("userid" , member.getUserid()).executeUpdate();
    }

    @Override
    public boolean findById(String userid) {
        return  em.find(Member.class, userid) == null;
    }

    @Override
    public Optional<Member> update(Member member) {
        em.persist(member);
        return Optional.ofNullable(member);
    }

}