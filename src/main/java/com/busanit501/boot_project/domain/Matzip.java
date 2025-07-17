package com.busanit501.boot_project.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Matzip extends BaseEntity {

    @Id
    @Column(name = "uc_seq")
    private Long ucSeq; // 일련번호 (Primary Key)

    @Column(name = "main_title")
    private String mainTitle; // 음식점명칭 (상호명)
    private String addr1; // 주소
    private String addr2; // 주소2
    @Column(name = "cntct_tel")
    private String cntctTel; // 전화번호
    @Column(name = "itemcntnts", length = 4000)
    private String itemcntnts; // 소개글 (설명)
    @Column(name = "usage_day_")
    private String usageDay; // 이용가능시간
    @Column(name = "main_img_n")
    private String mainImgN; // 메인이미지
    @Column(name = "main_img_t")
    private String mainImgT; // 메인이미지의 썸네일
    private String course; // 코스
    private String gugan; // 구간
    private String lat; // 위도
    private String lng; // 경도

    // 필요한 경우 setter 메서드 추가 (예: 데이터 업데이트 시)
    public void change(String mainTitle, String addr1, String cntctTel, String itemcntnts) {
        this.mainTitle = mainTitle;
        this.addr1 = addr1;
        this.cntctTel = cntctTel;
        this.itemcntnts = itemcntnts;
    }
}
