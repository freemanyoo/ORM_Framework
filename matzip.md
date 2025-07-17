# 부산 맛집 공공데이터 출력 프로젝트 계획

## 1. 프로젝트 목표

*   부산광역시의 맛집 공공데이터를 외부 API를 통해 가져와 웹 페이지에 목록 형태로 출력합니다.
*   가능하다면, 맛집 정보에 포함된 이미지도 함께 표시합니다.

## 2. 공공데이터 API 탐색 및 선정

*   **액션:** 부산광역시 또는 공공데이터 포털에서 "부산 맛집", "부산 음식점", "부산 관광" 등 관련 키워드로 공공데이터 API를 검색합니다.
    *   **예시 검색어:** "부산광역시 맛집 공공데이터", "부산 음식점 API", "공공데이터포털 부산 맛집"
*   **선정 기준:**
    *   무료로 사용 가능한 API (또는 적절한 무료 사용량 제공)
    *   맛집 이름, 주소, 전화번호, 카테고리, (선택 사항: 이미지 URL) 등 필요한 정보 포함 여부
    *   API 문서가 명확하고 사용하기 쉬운지 여부
*   **API 가입 및 키 발급:** 선정된 API가 인증(API Key)을 요구하는 경우, 해당 사이트에 가입하고 API 키를 발급받습니다. (이 과정은 사용자 직접 수행)
*   **API 문서 분석:** API 요청 URL, 필수/선택 파라미터, 응답 데이터 형식(JSON/XML), 응답 필드명 등을 상세히 파악합니다.

## 3. 데이터 모델 (DTO) 정의

*   **목표:** 선정된 공공데이터 API의 JSON/XML 응답 구조에 맞춰 Java DTO 클래스를 설계합니다.
*   **액션:**
    *   API 응답 예시를 분석하여 필요한 필드들을 식별합니다.
    *   `src/main/java/com/busanit501/boot_project/dto/matzip` 패키지를 생성합니다.
    *   `MatzipResponseDTO.java` (또는 API 응답에 적합한 이름) 파일을 생성하고, API 응답의 최상위 구조를 매핑합니다.
    *   필요에 따라 중첩된 객체(예: `Item`, `Row` 등)를 위한 내부 클래스를 `MatzipResponseDTO` 내부에 정의합니다.
    *   `lombok` 어노테이션 (`@Data`, `@AllArgsConstructor`, `@NoArgsConstructor`, `@JsonProperty` 등)을 활용하여 코드를 간결하게 작성합니다.

## 4. 서비스 계층 구현

*   **목표:** 공공데이터 API를 호출하고, 응답 데이터를 DTO 객체로 변환하여 반환하는 비즈니스 로직을 구현합니다.
*   **액션:**
    *   `src/main/java/com/busanit501/boot_project/service` 패키지에 `MatzipService.java` 인터페이스를 정의합니다. (예: `getMatzipList(PageRequestDTO pageRequestDTO)` 또는 `getMatzipList(String query, int page, int size)`)
    *   `MatzipServiceImpl.java` 구현체를 생성하고 `MatzipService` 인터페이스를 구현합니다.
    *   `RestTemplate` 또는 `WebClient`를 사용하여 공공데이터 API를 호출하는 로직을 작성합니다.
    *   API 키가 필요한 경우, `application.properties`에 키를 설정하고 `@Value` 어노테이션으로 주입받아 사용합니다.
    *   API 호출 실패 시 예외 처리 로직을 추가하여 안정성을 확보합니다.

## 5. 컨트롤러 계층 구현

*   **목표:** 웹 요청을 받아 서비스 계층의 기능을 호출하고, 가져온 맛집 데이터를 뷰(View)로 전달합니다.
*   **액션:**
    *   `src/main/java/com/busanit501/boot_project/controller` 패키지에 `MatzipController.java` (또는 `MatzipRestController` if only JSON) 파일을 생성합니다.
    *   맛집 목록을 보여줄 `GET` 매핑 메서드를 정의합니다. (예: `/matzip/list`)
    *   필요한 경우 검색 조건(예: `query`, `page`, `size`)을 `@RequestParam`으로 받습니다.
    *   `MatzipService`를 주입받아 맛집 데이터를 가져옵니다.
    *   가져온 데이터를 `Model` 객체에 담아 뷰로 전달합니다.

## 6. 뷰 (HTML) 구현

*   **목표:** 컨트롤러에서 전달받은 맛집 데이터를 사용자에게 시각적으로 보여줄 HTML 템플릿을 작성합니다.
*   **액션:**
    *   `src/main/resources/templates/matzip` 패키지를 생성합니다.
    *   `list.html` (또는 적절한 이름) 파일을 생성합니다.
    *   Thymeleaf 문법을 사용하여 `Model`에서 전달받은 맛집 목록을 반복문으로 출력합니다.
    *   각 맛집의 이름, 주소, 전화번호 등을 표시합니다.
    *   이미지 URL이 있는 경우, `<img>` 태그를 사용하여 이미지를 표시합니다. (이미지 로딩 실패 대비)

## 7. 스타일링 (CSS)

*   **목표:** 맛집 목록의 가독성과 디자인을 개선합니다.
*   **액션:**
    *   `src/main/resources/static/css` 패키지에 `matzip.css` 파일을 생성합니다.
    *   맛집 목록, 각 아이템, 이미지 등에 대한 CSS 스타일을 정의합니다.
    *   `list.html` 파일에서 `matzip.css` 파일을 링크합니다.

## 8. 테스트 및 확인

*   **목표:** 구현된 기능이 정상적으로 작동하는지 확인합니다.
*   **액션:**
    *   Spring Boot 애플리케이션을 재시작합니다.
    *   웹 브라우저에서 `http://localhost:8080/matzip/list` (또는 정의한 URL)에 접속하여 맛집 목록이 올바르게 출력되는지 확인합니다.
    *   콘솔 로그를 통해 API 호출 성공 여부, 데이터 매핑 오류 여부 등을 확인합니다.
    *   다양한 검색 조건(있는 경우)으로 테스트하여 기능의 견고성을 확인합니다.
