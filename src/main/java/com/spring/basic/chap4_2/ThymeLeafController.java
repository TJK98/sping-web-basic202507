package com.spring.basic.chap4_2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/chap4-")
public class ThymeLeafController {

    @GetMapping("/hobby-page")
    public String hobbypage(Model model) {
        model.addAttribute("username", "하하");
        model.addAttribute("hobbies", List.of("달리기", "웃기기", "노래 부르기"));
        return "hobby";
    }
}
