package com.busanit501.boot_project.dto.matzip;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JacksonXmlRootElement(localName = "OpenAPI_ServiceResponse")
public class MatzipErrorResponseDTO {

    @JacksonXmlProperty(localName = "cmmMsgHeader")
    private CmmMsgHeader cmmMsgHeader;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CmmMsgHeader {
        @JacksonXmlProperty(localName = "errMsg")
        private String errMsg;
        @JacksonXmlProperty(localName = "returnAuthMsg")
        private String returnAuthMsg;
        @JacksonXmlProperty(localName = "returnReasonCode")
        private String returnReasonCode;
    }
}
