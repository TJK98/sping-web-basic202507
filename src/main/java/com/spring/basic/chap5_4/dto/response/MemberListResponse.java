package com.spring.basic.chap5_4.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.basic.chap3_2.entity.Member;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

// 클라이언트에게 맴버 목록을 보내줄 때 사용할 응답 DTO
public class MemberListResponse {
    private String id;

    @JsonProperty("account") // JSON에서는 account로 바뀐다.
    private String email; // account에 대응

    private String nick; // 가운데 글자 마스킹 (첫글자랑 마지막 글자 빼고)

    @JsonIgnore // JSON에서 넘겨주고 싶지 않으면 쓴다.
    private String cardNo;

    @JsonFormat(pattern = "yyyy년 MM월 dd일") // 바로 패턴 지정이 가능하다.
    private LocalDate creationTime;

    // MemberListResponse가 해야 할 일은 엔터티를 전달 받아서 dto로 변환하는 정적 팩토리 메서드
    public static MemberListResponse from(Member member) {
        return MemberListResponse.builder()
                .id(member.getUid())
                .email(member.getAccount())
                .nick(maskingNickName(member.getNickname()))
                .creationTime(LocalDate.now())
                .build();
    }

    private static String maskingNickName(String originNick) {
        return originNick.charAt(0) + "*" + originNick.charAt(originNick.length() - 1);
    }

}
