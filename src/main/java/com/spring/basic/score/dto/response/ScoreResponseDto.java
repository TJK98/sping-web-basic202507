package com.spring.basic.score.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.basic.score.entity.Score;
import lombok.*;

/*
    [응답용 DTO: ScoreResponseDto]

    클라이언트에게 전달할 성적 정보를 담는 응답 객체입니다.
    - 내부 Entity(Score)를 외부에 직접 노출하지 않고,
      필요한 정보만 선별하여 전달합니다.
    - 프론트엔드에서 요구하는 필드명(JSON Key)에 맞춰 @JsonProperty를 설정합니다.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreResponseDto {

    private Long id; // 학번

    @JsonProperty("maskingName")
    private String maskingName; // 마스킹 처리된 이름

    @JsonProperty("sum")
    private int sum; // 총점

    @JsonProperty("avg")
    private double avg; // 평균

    @JsonProperty("rank")
    private int rank; // 석차 (초기값은 0, 후처리에서 계산)

    /**
     * 정적 팩토리 메서드 (Static Factory Method)
     * - Score 엔티티 객체를 받아서,
     *   클라이언트 응답용 DTO로 변환
     * - Entity를 외부에 직접 노출하지 않기 위한 보안/설계상의 이점
     *
     * @param score 성적 정보 엔티티
     * @return ScoreResponseDto 변환 객체
     */
    public static ScoreResponseDto from(Score score) {
        return ScoreResponseDto.builder()
                .id(score.getId())
                .maskingName(maskName(score.getName()))
                .sum(score.getTotal())
                .avg(score.getAverage())
                .rank(0)
                .build();
    }

    /**
     * 이름 마스킹 유틸리티
     * - 이름 길이에 따라 마스킹 규칙 적용
     *   - 2글자: 마지막 글자만 마스킹
     *   - 3글자: 가운데 글자만 마스킹
     *   - 4글자 이상: 첫 글자와 마지막 글자를 제외한 모든 글자 마스킹
     *
     * @param name 마스킹 대상 이름
     * @return 마스킹 처리된 이름 문자열
     */
    private static String maskName(String name) {
        if (name == null || name.length() < 2) return name;

        int len = name.length();
        StringBuilder sb = new StringBuilder();

        if (len == 2) {
            sb.append(name.charAt(0)).append("*");
        } else if (len == 3) {
            sb.append(name.charAt(0)).append("*").append(name.charAt(2));
        } else {
            sb.append(name.charAt(0)); // 첫 글자
            for (int i = 1; i < len - 1; i++) {
                sb.append("*"); // 가운데 글자들
            }
            sb.append(name.charAt(len - 1)); // 마지막 글자
        }
        return sb.toString();
    }
}
