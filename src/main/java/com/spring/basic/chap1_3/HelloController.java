package com.spring.basic.chap1_3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

// DispatcherServlet이 이 객체를 하위 컨트롤러로 인식
@Controller
public class HelloController {

    @RequestMapping("/chap01/hello")
    @ResponseBody // 이 아노테이션이 있으면 json을 리턴하려고 시도, 없으면 view를 찾는다.
    public Map<String, Object> hello() {
        System.out.println("hello spring MVC!");
        return Map.of(
                "name", "왕택준",
                "age", 26
        );
    }

    // 컨트롤러 기능 - 요청을 처리, 뷰를 선택해서 포워딩 기능
    @RequestMapping("/chap01/bye")
    public String bye() {
        System.out.println("goodbye spring MVC!");

        // bye.jsp를 열어주고 싶음( 뷰 포어딩 )
//        return "/WEB-INF/views/bye.jsp";
        /*spring.mvc.view.prefix=/WEB-INF/views/
        spring.mvc.view.suffix=.jsp
        를 application.properties에 넣으면 간소화 하게 쓸 수 있다.*/
        return "bye";
    }

}
