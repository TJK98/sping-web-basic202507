package com.spring.basic.chap2_4.entity;

import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    // null과 0의 차이 : null은 가격 자체가 설정이 안 된 것, 0은 공짜, 0원이라는 뜻
    private Long id; // 책을 유일하게 구분할 수 있는 식별자
    private String title;
    private String author;
    private int price;

    // 수정 편의 메서드
    public void updateBookInfo(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
