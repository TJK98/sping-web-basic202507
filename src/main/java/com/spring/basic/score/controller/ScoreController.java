/*
package com.spring.basic.score.controller;

import com.spring.basic.score.dto.request.ScoreRequestDto;
import com.spring.basic.score.dto.response.ScoreResponseDto;
import com.spring.basic.score.entity.Score;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

    1. POST - 등록 API
    2. GET - 전체 조회
    3. DELETE - 삭제
    4. GET - 상세 조회
    5. 프론트 연동 (JS)



@RestController
@RequestMapping("/api/v1/scores")
@Slf4j
public class ScoreController {

    private Map<Long, Score> scoreMap = new HashMap<>();
    private long id = 1L;

     1단계: 클라이언트 → 서버로 점수 데이터를 보냄
     2단계: 컨트롤러가 DTO로 데이터를 받음
     3단계: DTO → Entity로 변환
     4단계: Map<Long, Score>에 저장
     5단계: 응답 반환

     [Client] → POST /api/scores
                ↓
    [Controller] → @RequestBody ScoreRequestDto + @Valid
                ↓
    검증 성공 → DTO → Score 변환
                ↓
    Map에 저장 (id 자동 증가)
                ↓
    응답: "등록 완료!" or 저장된 객체 반환


    @PostMapping
    public ResponseEntity<?> registerScore ( // 이 메서드는 HTTP 요청을 처리하고, 응답(Response)을 반환
            @RequestBody // 클라이언트가 요청 본문(body)에 보낸 JSON을 자바 객체(dto)로 변환 (매핑)
            @Valid // ScoreRequestDto에 있는 유효성 검증 조건을 실행
            ScoreRequestDto dto, // JSON이 매핑된 자바 객체
            BindingResult bindingResult // 유효성 검사 결과를 담는 객체 (검증 실패 시 오류 정보가 들어감)
    ) {
        // [1] Score 객체 생성 (학생 1명의 성적 정보를 저장할 객체)
        Score score = new Score();

        // [2] 학번 자동 증가 후 할당
        score.setId(id++);

        // [3] 이름, 과목 점수 복사 (DTO에서 값 꺼내서 엔티티로 전달)
        score.setName(dto.getStudentName());
        score.setKor(dto.getKorean());
        score.setEng(dto.getEnglish());
        score.setMath(dto.getMath());

        // [4] 과목 점수들을 List로 묶어서 총점과 평균 계산 (과목이 늘어나도 구조 확장 가능)
        List<Integer> scores = List.of(
                dto.getKorean(),
                dto.getEnglish(),
                dto.getMath()
        );

        // [5] 총점 계산: stream을 이용해 점수 리스트를 모두 더함
        int total = scores.stream().mapToInt(i -> i).sum();

        // [6] 평균 계산: 총점을 과목 수로 나누고 실수로 변환
        double avg = (double) total / scores.size();

        // [7] 계산된 총점, 평균을 score 객체에 저장
        score.setTotal(total);
        score.setAverage(avg);

        // [8] 저장소(Map)에 등록 (key: 학번, value: score 객체)
        scoreMap.put(score.getId(), score);

        // [9] 응답 반환: 등록 성공 메시지를 클라이언트에 전송
        return ResponseEntity.ok("등록 완료!");
    }

         1단계: 클라이언트가 목록 조회 요청 보냄 (정렬 기준 포함)
         2단계: Map에서 모든 성적 데이터 추출
         3단계: List<Score>로 변환 후 정렬 기준에 맞게 정렬
         4단계: JSON 형식으로 응답 반환

         [Client] → GET /api/v1/scores?sort=name
                     ↓
         [Controller] → scoreMap.values() → List<Score>
                     ↓
         이름순으로 정렬 (Comparator 사용)
                     ↓
         응답: 정렬된 전체 성적 리스트 (JSON)


    @GetMapping
    public ResponseEntity<?> getScoreList(
            @RequestParam(defaultValue = "id") String sort
    ) {
        List<ScoreResponseDto> scoreList = scoreMap.values()
                .stream()
                .sorted(getComparator(sort))             // Score 기준으로 정렬
                .map(ScoreResponseDto::from)             // Score → DTO로 변환
                .collect(toList());

        return ResponseEntity.ok(scoreList);
    }

    private Comparator<Score> getComparator(String sort) {
        if ("name".equals(sort)) {
            return comparing(Score::getName);
        } else if ("average".equals(sort)) {
            return comparing(Score::getAverage);
        } else {
            return comparing(Score::getId);
        }
    }
}
*/
