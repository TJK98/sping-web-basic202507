package com.spring.basic.chap2_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // JSP 같은 뷰를 핸들링 하는 컨트롤러
@RestController // JSON을 리턴하는 컨트롤러
@RequestMapping("/chap2-2") // 공통의 주소 처리 가능
public class BasicController {

    /*
        GET    : 조회
        POST   : 생성
        PUT    : 수정
        DELETE : 삭제
     */

    // 헨들러 메서드 (각 요청을 전담 처리)
//    @RequestMapping(value = "/chap2-2/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
//    curl.exe -X GET "http://localhost:9000/chap2-2/hello" <- 터미널에서 가능

    //    @ResponseBody // JSON을 리턴
    public String hello() {
        return "Hello Spring";
    }

    @PostMapping("/hobby")
    public List<String> greet() {
        return List.of("헬스", "걷기", "노래", "게임");
    }
}
