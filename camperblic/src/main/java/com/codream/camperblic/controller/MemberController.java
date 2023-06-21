package com.codream.camperblic.controller;

import com.codream.camperblic.domain.login.Member;
import com.codream.camperblic.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
public class MemberController {

    private final MemberService memberService;
    private final JwtUtil jwtUtil;
    private PasswordEncoder passwordEncoder;

    public void hihi(){

    };
    @Autowired
    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PutMapping("/changepw")
    public ResponseEntity<String> changepw(@RequestBody Member member, @RequestParam("changePw") String password) {
        try {
            String encodePw = passwordEncoder.encode(password);
            member.setPassword(encodePw);
            memberService.changePw(member);
            return ResponseEntity.ok().body("비밀번호 변경 성공했습니다. 로그인 해주세요");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("비밀번호 변경 실패");
        }
    }

    @GetMapping("/finduserid")
    public ResponseEntity<Member> finduserid(@RequestParam("userIdData") String userid) {
        try {
            Member member = memberService.findByUserId(userid)
                    .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
            return ResponseEntity.ok().body(member);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 세션 무효화
            request.getSession().invalidate();

            // 쿠키 제거
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    cookie.setSecure(true); // Secure 속성 설정
                    response.addCookie(cookie);
                }
            }

            // 'Access-Control-Allow-Origin' 헤더 설정
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
            // 'Access-Control-Allow-Credentials' 헤더 설정
            response.setHeader("Access-Control-Allow-Credentials", "true");

            return ResponseEntity.ok().body("로그아웃 성공하셨습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("로그아웃 실패");
        }
    }


    @PutMapping("/deletemember")
    public ResponseEntity<String> deletemember(@CookieValue(value = "token", required = false) String token,
                                               HttpServletRequest request, HttpServletResponse response) {
        if (!jwtUtil.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰이 유효하지 않습니다");
        }
        try {
            String userid = jwtUtil.getUseridFromToken(token);
            Optional<Member> userData = memberService.findByUserId(userid);
            if (!userData.isPresent()) {
                return ResponseEntity.notFound().build();
            } else {
                userData.get().setUseyn(2);
                memberService.deleteMember(userData.get());
                // 세션 무효화
                request.getSession().invalidate();

                // 쿠키 제거
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
                return ResponseEntity.ok().body("회원 탈퇴를 성공하셨습니다.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/updateinfo")
    public ResponseEntity<Member> updateinfo(@CookieValue(value = "token", required = false) String token, @RequestBody Member member) {
        if (!jwtUtil.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        try {
            System.out.println(member.toString());
            String userid = jwtUtil.getUseridFromToken(token);
            Optional<Member> userData = memberService.findByUserId(userid);
            if (!userData.isPresent()) {
                return ResponseEntity.notFound().build();
            } else {
                Member user = userData.get();
                user.setName(member.getName());
                user.setEmail(member.getEmail());
                user.setPhone(member.getPhone());
                memberService.update(user);
                System.out.println(user.toString());
                return ResponseEntity.ok().body(user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/addAddress")
    public ResponseEntity<Member> addAddress(@CookieValue(value = "token", required = false) String token, @RequestBody Member member) {
        if (!jwtUtil.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        try {
            System.out.println(member.toString());
            String userid = jwtUtil.getUseridFromToken(token);
            Optional<Member> userData = memberService.findByUserId(userid);
            if (!userData.isPresent()) {
                return ResponseEntity.notFound().build();
            } else {
                Member user = userData.get();
                user.setAddress1(member.getAddress1());
                user.setAddress2(member.getAddress2());
                user.setAddress3(member.getAddress3());
                user.setAddress4(member.getAddress4());
                memberService.update(user);
                System.out.println(user);
                return ResponseEntity.ok().body(member);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/mypage")
    public ResponseEntity<Member> findTokenUserId(@CookieValue(value = "token", required = false) String token) {
        if (!jwtUtil.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        String userid = jwtUtil.getUseridFromToken(token);
        Optional<Member> member = memberService.findByUserId(userid);
        if (member.isPresent()) {
            return ResponseEntity.ok(member.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Member member, HttpSession session, HttpServletResponse response) {
        try {
            String userid = member.getUserid();
            String userPw = member.getPassword();
            Member foundMember = memberService.findByUserId(userid)
                    .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
            // 시큐리티 버전
            if (!passwordEncoder.matches(userPw, foundMember.getPassword())) {
                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
            }
            // 세션에 로그인 정보 저장
            session.setAttribute("username", foundMember.getName());
            session.setAttribute("userid", foundMember.getUserid());

            // JWT 토큰 생성
            String token = jwtUtil.generateToken(foundMember.getUserid(), foundMember.getName());

            // JWT 토큰을 쿠키로 설정
            Cookie tokenCookie = new Cookie("token", token);
            tokenCookie.setPath("/");
            tokenCookie.setHttpOnly(true);
            response.addCookie(tokenCookie);

            return ResponseEntity.ok("로그인 성공");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }


    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Member member) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH:mm");
        String currentDate = dateFormat.format(new Date());
        if (!memberService.findById(member.getUserid())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재하는 아이디입니다.");
        }

        try {
            String encodePw = passwordEncoder.encode(member.getPassword());
            Member user = new Member();
            user.setUserid(member.getUserid());
            user.setPassword(encodePw);
            user.setName(member.getName());
            user.setEmail(member.getEmail());
            user.setPhone(member.getPhone());
            user.setUseyn(1);
            user.setCreatedDate(currentDate);
            memberService.saveUser(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}