package com.spring.basic.chap3_3.controller;

import com.spring.basic.chap3_2.entity.Member;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v3-3/members")
//@CrossOrigin("http://127.0.0.1:5500")
public class MemberController3_3 {

    private Map<String, Member> memberStore = new HashMap<>();

    public MemberController3_3() {

        Member member1 = Member.builder()
                .account("abc123")
                .password("9999")
                .nickname("뽀롱이")
                .build();

        Member member2 = Member.builder()
                .account("def9876")
                .password("4444")
                .nickname("핑순이")
                .build();

        memberStore.put(member1.getUid(), member1);
        memberStore.put(member2.getUid(), member2);

    }

    // 전체 조회
    @GetMapping
    public ResponseEntity<?> list() {
        /*try {
            String str = null;
            str.charAt(0);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("서버 에러가 생겼습니다. 죄송합니다");
        }*/

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("my-pet", "cat");
        httpHeaders.add("my-hobby", "sing");

        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(new ArrayList<>(memberStore.values()));
    }

    // 회원 생성 ResponseEntity 버전
    @PostMapping
//    public String join(@RequestBody Member member, HttpServletResponse response)
    public ResponseEntity<String> join(@RequestBody Member member) {

        // 계정이 비어있는지 확인
        if (member.getAccount().isBlank()) {
//            response.setStatus(400);
//            return "계정은 필수값입니다.";
            return ResponseEntity
                    .badRequest() // status(400)
                    .body("계정은 필수 값입니다.");
        }

        member.setUid(UUID.randomUUID().toString());
        memberStore.put(member.getUid(), member);
        return ResponseEntity
                .ok() // status(200)
                .body("새로운 맴버가 생성됨! - nickname: " + member.getNickname());
    }

    // 단일 조회 (계정명으로 조회)
    @GetMapping("/{account}")
    public ResponseEntity<?> findOne(@PathVariable String account) {

        Member foundMember = null;

        for (String key : memberStore.keySet()) {
            Member member = memberStore.get(key);
            if (member.getAccount().equals(account)) {
                foundMember = member;
            }
        }

        /*Member foundMember = memberStore.values()
                .stream()
                .filter(member -> member.getAccount().equals(account))
                .findFirst()
                .orElse(null);*/

        if (foundMember == null) {
            return ResponseEntity
                    .status(404)
                    .body(account + "는(은) 존재하지 않는 계정입니다.");
        }

        return ResponseEntity.ok().body(foundMember);
    }


}