package com.spring.basic.chap5_5.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.basic.chap5_5.entity.Feed;
import lombok.Builder;

@Builder
public class FeedDetailResponse {

    // 피드 Id, 생성시간 제외
    // 작성자명 (writer), 피드내용은 (feed_content), 조회수 (view) 응답
    private String writer;

    @JsonProperty("feed_content")
    private String content;

    private int view;

    public static FeedDetailResponse from(Feed feed) {
        return FeedDetailResponse.builder()
                .writer(feed.getWriter())
                .content(feed.getContent())
                .view(feed.getViewCount())
                .build();
    }
}
