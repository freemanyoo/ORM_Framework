package com.busanit501.boot_project.dto.matzip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatzipDTO {
    private Long ucSeq; // 일련번호
    private String mainTitle; // 음식점명칭 (상호명)
    private String addr1; // 주소
    private String cntctTel; // 전화번호
    private String itemCntnts; // 소개글 (설명)
    private String usageDay; // 이용가능시간
    private String mainImgN; // 메인이미지
    private String mainImgT; // 메인이미지의 썸네일
    private String course; // 코스
    private String gugan; // 구간
    private String lat; // 위도
    private String lng; // 경도
}
