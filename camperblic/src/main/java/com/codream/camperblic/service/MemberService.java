package com.codream.camperblic.service;

import com.codream.camperblic.domain.login.Member;
import com.codream.camperblic.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {this.memberRepository = memberRepository;}
    public Optional<Member> findByUserId(String userid) {return memberRepository.findByUserId(userid);}

    public Optional<Member> update(Member member) {return memberRepository.update(member);}

    public void  changePw(Member member) {memberRepository.changepw(member);}
    public void saveUser(Member member) {  memberRepository.save(member);}
    public void deleteMember(Member member) {memberRepository.save(member);}

    public boolean findById(String userid) { return memberRepository.findById(userid); }
}