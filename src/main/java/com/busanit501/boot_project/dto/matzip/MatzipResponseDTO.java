package com.busanit501.boot_project.dto.matzip;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatzipResponseDTO {

    @JsonProperty("response")
    private Response response;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {

        @JsonProperty("header")
        private Header header;

        @JsonProperty("body")
        private Body body;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Header {

        @JsonProperty("resultCode")
        private String resultCode;

        @JsonProperty("resultMsg")
        private String resultMsg;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Body {

        @JsonProperty("items")
        private Items items;

        @JsonProperty("numOfRows")
        private int numOfRows;

        @JsonProperty("pageNo")
        private int pageNo;

        @JsonProperty("totalCount")
        private int totalCount;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Items {

        @JsonProperty("item")
        private List<Item> item;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {

        @JsonProperty("uc_seq")
        private int ucSeq;

        @JsonProperty("main_title")
        private String mainTitle;

        @JsonProperty("addr1")
        private String addr1;

        @JsonProperty("cntct_tel")
        private String cntctTel;

        @JsonProperty("usage_day_week_and_time")
        private String usageDayWeekAndTime;

        @JsonProperty("main_img_n")
        private String mainImgNormal;

        @JsonProperty("main_img_t")
        private String mainImgThumb;

        @JsonProperty("itemcntnts")
        private String itemCntnts;

        @JsonProperty("lat")
        private double lat;

        @JsonProperty("lng")
        private double lng;
    }
}
