package com.spring.basic.score.entity;

import lombok.*;

/*
1단계 - 프로젝트 생성 + 패키지 구조 만들기
2단계 - Score 클래스 만들기
3단계 - Map 저장소 선언
4단계 - 등록 API + DTO 만들기
5단계 - 전체 조회 API 만들기
6단계 - 삭제 API 만들기
7단계 - 상세 조회 API 만들기
8단계 - HTML + JS 연결 (등록, 조회, 삭제)
*/

// 학생 한명의 성적정보를 저장
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Score {
    private Long id; // 학번
    private String name; // 이름
    private int kor; // 국어 점수
    private int eng; // 영어 점수
    private int math; // 수학 점수
    private int total; // 총점
    private double average; // 평균
    private int rank; // 성적 순위

    public Score(Long id, String name, int kor, int eng, int math) {
        this.id = id;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        calcTotalAndAverage();
    }

    // 총점 평균을 구하는 메서드
    public void calcTotalAndAverage() {
        this.total = this.kor + this.eng + this.math;
        this.average = this.total / 3.0;
    }
}