package com.spring.basic.score.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScorePageController {

    // 성적 등록 및 목록 보기 페이지
    @GetMapping("/score/page")
    public String showScoreMainPage(Model model) {
        model.addAttribute("title", "성적 관리");
        return "score/score-page"; // -> /WEB-INF/views/score/score-page.jsp
    }

    // 성적 상세 보기 페이지
    @GetMapping("/score/detail")
    public String showScoreDetailPage() {
        return "score/score-detail"; // -> /WEB-INF/views/score/score-detail.jsp
    }
}