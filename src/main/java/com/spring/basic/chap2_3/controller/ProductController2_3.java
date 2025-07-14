package com.spring.basic.chap2_3.controller;

import com.spring.basic.chap2_3.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // JSON 처리
@RequestMapping("/products")
public class ProductController2_3 {

    // 가상의 메모리 상품 저장소
    private Map<Long, Product> productMap = new HashMap<>();

    // 상품의 시리얼 넘버를 순차 생성
    private long nextId = 1;

    public ProductController2_3() {
        productMap.put(nextId, new Product(nextId, "에어컨", 1000000));
        nextId++;
        productMap.put(nextId, new Product(nextId, "세탁기", 1500000));
        nextId++;
        productMap.put(nextId, new Product(nextId, "공기청정기", 3000000));
        nextId++;
    }

    // 특정 상품 조회 : GET
    /*@GetMapping // ("")를 안 쓰면 빈문자다 공통인 /products가 주소
    public Product getProduct(HttpServletRequest req) {
        String id = req.getParameter("id");
        return productMap.get(Long.parseLong(id));
    }*/

    // 쿼리스트링 읽기   ?id=xxx&price=4000
    @GetMapping
    public Product getProduct(
            @RequestParam("id") long id, // @RequestParam("id") 안에 id 와 long id와 id가 같으면 @RequestParam("id") 생략 가능
            @RequestParam(value="price", required = false, defaultValue = "1000") int price
    ) {
        System.out.println("id = " + id);
        System.out.println("price = " + price);
        return productMap.get(id);
    }

    // localhost:9000/products/1 -> 1번 상품 조회
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return productMap.get(id);
    }
}
