package com.spring.basic.chap2_3.entity;

import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor

// @Data <- 이건 모든 걸 다 만들어줘서 원하는 것만 만들 수 없다 (커스텀 불가능)
public class Product {

    private Long serialNo; // 상품 시리얼 번호
    private String name; // 상품명
    private int price; // 상품 가격
}
