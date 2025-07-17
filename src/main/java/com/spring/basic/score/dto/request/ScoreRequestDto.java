/*
package com.spring.basic.score.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

*/
/*
    클라이언트(브라우저)가 보낸 성적 등록 요청 데이터를 담는 DTO 클래스.
    - 필드명은 프론트 JS 코드에서 보낸 키와 일치시킴
    - 유효성 검사(Validation)를 통해 잘못된 입력을 방지
 *//*

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreRequestDto {
    */
/*
        이름 입력 유효성 검사
        - @NotBlank: null, 빈 문자열, 공백만 있는 문자열 금지
        - @Pattern: 한글 또는 영문만 허용 (2~10자)
     *//*

    @NotBlank(message = "이름을 입력하세요.") // 공백만 입력하거나 빈 칸이면 오류
    @Pattern(
            regexp = "^[가-힣a-zA-Z]{2,10}$",
            message = "이름은 한글 또는 영문 2~10자 이내여야 합니다."
    )
    private String studentName; // 이름

    */
/*
        점수 입력 유효성 조건 (국어, 영어, 수학 공통)
        - 정수 타입(int)은 @NotBlank 사용 불가 (문자열 전용)
        - @Min: 최소값 지정
        - @Max: 최대값 지정
        주의: int는 null을 허용하지 않기 때문에, 프론트에서 빈 칸으로 제출되면 400 에러 발생
     *//*

    @Min(value = 0, message = "점수는 0 이상이어야 합니다.")
    @Max(value = 100, message = "점수는 100 이하여야 합니다.")
    private int korean; // 국어 점수

    @Min(value = 0, message = "점수는 0 이상이어야 합니다.")
    @Max(value = 100, message = "점수는 100 이하여야 합니다.")
    private int english; // 영어 점수

    @Min(value = 0, message = "점수는 0 이상이어야 합니다.")
    @Max(value = 100, message = "점수는 100 이하여야 합니다.")
    private int math; // 수학 점수
}
*/
