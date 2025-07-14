package com.spring.basic.chap2_3.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/practice/api/v1")
public class PracticeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring MVC!";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        return "Product ID: " + id;
    }

    @GetMapping("/books")
    public String getBooks(String author, String genre) {
        return "Author: " + author + ", Genre: " + genre;
    }

    @GetMapping("/search")
    public String search(String query,
                         @RequestParam(value = "Spring", defaultValue = "1") int page) {
        return "Query: " + query + ", Page: " + page;
    }

    @GetMapping("/info/{userId}")
    public String getInfo(@PathVariable String userId) {
        return "User Info: " + userId;
    }
}
