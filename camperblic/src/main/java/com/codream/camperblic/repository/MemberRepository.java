package com.codream.camperblic.repository;

import com.codream.camperblic.domain.login.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Optional<Member> findByUserId(String userid);

    void save(Member member);

    void changepw(Member member);

    boolean findById(String userid);
    Optional<Member> update(Member member);

}