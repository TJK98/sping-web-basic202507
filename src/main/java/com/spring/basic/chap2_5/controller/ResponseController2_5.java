package com.spring.basic.chap2_5.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/api/v2-5")
public class ResponseController2_5 {

    // 페이지 라우팅 - 특정 뷰 (JSP, thymeleaf)를 포워딩 해주는 것
    @GetMapping("/book-page")
    public String bookPage() {
        return "book-page";
    }

    // 클라이언트에게 데이터 응답
    // HTML 응답
    @GetMapping("/show/html")
    @ResponseBody // 순수 데이터를 클라이언트에게 전달
    public String html() {
        return """
                <html>
                <body>
                    <h1>HTML 응답하기</h1>
                </body>
                </html>
                """;
    }

    // 순수 텍스트 응답하기
    @GetMapping(value = "/show/text"
            , produces = "text/plain") // produces를 안 쓰면 text/html이 기본 타입
    @ResponseBody // 2가지 JSON이거나 HTML이거나
    public String text() {
        return "Hi I am text";
    }

    @GetMapping(value = "/show/text2"
            , produces = "application/json") // produces를 안 쓰면 application/json이 기본 타입
    @ResponseBody
    public Map<String, Object> text2() {
        return Map.of(
                "message", "Hi I am text2"
        );
    }

    // JSON 배열 응답 - 자바 배열이나 List, Set
    @GetMapping("/json/array")
    @ResponseBody
    public List<String> hoobies() {
        return List.of("축구", "게임", "노래");
    }

    // JSON 객체 응답 - 자바의 클래스의 인스턴스(객체) or Map
    @GetMapping("/json/object")
    @ResponseBody
    public Map<String, Object> myPet() {
        return Map.of(
                "name", "야옹이",
                "age", 3,
                "kind", "코리안숏헤어"
        );
    }

    @GetMapping("/json/object2")
    @ResponseBody
    public Pet myPet2() {
        return new Pet("냥냥이", 5, "페르시안", true);
    }

    @GetMapping("/json/object3")
    @ResponseBody
    public List<Pet> myPet3() {
        return List.of(
                new Pet("냥냥이", 5, "페르시안", true),
                new Pet("냥냥이2", 6, "페르시안2", false),
                new Pet("냥냥이3", 7, "페르시안3", true),
                new Pet("냥냥이4", 8, "페르시안4", false)
        );
    }

    @ToString
    @Getter
    @AllArgsConstructor
    public static class Pet {
        private String name;
        private int age;
        private String kind;
        private boolean injection;
    }

}
