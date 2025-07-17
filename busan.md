

공공데이터 개방•공유•활용 체계 개발
Open API 활용가이드

















1. 서비스 명세	3
   1.1 공공데이터 OpenAPI 조회 서비스	3
   가. API 서비스 개요	3
   나. 상세기능 목록	3
   다. 상세기능내역	4
1) [갈맷길주변명소정보] 상세기능명세	4
2) [갈맷길주변맛집정보] 상세기능명세	13
3) [갈맷길주변숙박시설정보] 상세기능명세	23
2. OpenAPI 에러 코드정리	33



1. 서비스 명세
   1.1 공공데이터 OpenAPI 조회 서비스
   가. API 서비스 개요

API 서비스 정보
API명(영문)
fbusangmgtourinfo
API명(국문)
부산갈맷길관광정보안내
API 설명
부산시 갈맷길 관광 안내 정보를 조회 할 수 있는 서비스
API 서비스
보안적용
기술 수준
서비스 인증/권한
[O] ServiceKey    [ ] 인증서 (GPKI/NPKI)
[ ] Basic (ID/PW)  [ ] 없음
메시지 레벨
암호화
[ ] 전자서명   [ ] 암호화   [O] 없음
전송 레벨 암호화
[ ] SSL   [O] 없음
인터페이스 표준
[ ] SOAP 1.2
(RPC-Encoded, Document Literal, Document Literal Wrapped)
[O] REST (GET)
[ ] RSS 1.0   [ ] RSS 2.0   [ ] Atom 1.0   [ ] 기타
교환 데이터 표준
(중복선택가능)
[ O ] XML   [ O ] JSON   [ ] MIME   [ ] MTOM
API 서비스
배포정보
서비스 URL
http://apis.data.go.kr/6260000/fbusangmgtourinfo
서비스 명세 URL
(WSDL 또는 WADL)
http://apis.data.go.kr/6260000/fbusangmgtourinfo?_wadl&type=xml
서비스 버전
1.0
서비스 시작일
2021-01-02
서비스 배포일
2021-01-03
서비스 이력
2021-01-02 : 서비스 시작
메시지 교환유형
[O] Request-Response   [ ] Publish-Subscribe
[ ] Fire-and-Forgot   [ ] Notification
서비스 제공자
김창락 / 걷기좋은부산추진단 / 051-888-1304 / laks779@korea.kr
데이터 갱신주기
년 2회



나. 상세기능 목록

번호
API명(국문)
상세기능명(영문)
상세기능명(국문)
1
부산갈맷길관광정보안내
getgmgtourinfo
갈맷길주변명소정보
2
부산갈맷길관광정보안내
getgmgfoodinfo
갈맷길주변맛집정보
3
부산갈맷길관광정보안내
getgmghotelinfo
갈맷길주변숙박시설정보
다. 상세기능내역
1) [갈맷길주변명소정보] 상세기능명세
   a) 상세기능정보

상세기능 번호
1
상세기능 유형
조회 (목록)
상세기능명(국문)
갈맷길주변명소정보
상세기능 설명
① 갈맷길코스와 구간을 이용해 ② SEQ, 구분, 위치, 주소, 상태, 코스, 구간 등 ③ 갈맷길 주변의 명소를 조회하는 기능
Call Back URL
http://apis.data.go.kr/6260000/fbusangmgtourinfo/getgmgtourinfo
최대 메시지 사이즈
[16000] byte
평균 응답 시간
[187] ms
초당 최대 트랙잭션
[50] tps

b) 요청 메시지 명세

항목명(영문)
항목명(국문)
항목크기
항목구분
샘플데이터
항목설명
ServiceKey
인증키
100
1
인증키
(URL Encode)
공공데이터포털에서 발급받은 인증키
numOfRows
검색건수
4
1
10
검색건수
pageNo
페이지 번호
4
1
1
페이지 번호
resultType
JSON방식 호출
4
0
json
JSON방식으로 호출 시 파라미 resultType=json 입력
※ 항목구분 : 필수(1), 옵션(0), 1건 이상 복수건(1..n), 0건 또는 복수건(0..n)



c) 응답 메시지 명세

항목명(영문)
항목명(국문)
항목크기
항목구분
샘플데이터
항목설명
numOfRows
한 페이지 결과 수
4
1
10
한 페이지당 표출 데이터 수
pageNo
페이지 수
4
1
1
페이지 수
resultCode
결과코드
2
1
00
결과코드
resultMsg
결과메시지
50
1
OK
결과메시지
totalCount
데이터 총 개수
4
1
85
데이터 총 개수
name
관리를 위한 명칭
30
0
턴투워드부산(한,영,중간,중번,일)
관리를 위한 명칭
uc_seq
일련번호
5
0
1016
일련번호
cate1_nm
종류
20
0
명소
종류
place
장소
50
0
유엔기념공원, 유엔평화기념관
장소
title
제목
100
0
턴 투워드 부산(Turn Toward Busan)
제목
main_img_n
메인이미지
300
0
/uploadImgs/files/cntnts/20201106141515814_ttiel
메인이미지
main_img_t
메인이미지의 썸네일
300
0
/uploadImgs/files/cntnts/20201106141515814_thumbL
메인이미지의 썸네일
itemcntnts
소개글
4000
0
매년 11월 11일 11시가 되면 부산에서1분간 사이렌이 울립니다. 6.25참전 유엔전사자의 희생과 헌신을 기억하는 순간, 『턴 투워드 부산(Turn Toward Busan) 유엔참전용사 국제추모식』 행사가 열리기
소개글
course
코스
2
0
3
코스
gugan
구간
2
0
1
구간
lat
위도
50
0
35.127785
위도
lng
경도
50
0
129.09766
경도
※ 항목구분 : 필수(1), 옵션(0), 1건 이상 복수건(1..n), 0건 또는 복수건(0..n)
d) 요청/응답 메시지 예제

요청메시지
http://apis.data.go.kr/6260000/fbusangmgtourinfo/getgmgtourinfo?ServiceKey=서비스키&numOfRows=10&pageNo=1
응답메시지
<?xml version="1.0" encoding="UTF-8"?><response>
  <header>
    <resultMsg>NORMAL_CODE</resultMsg>
    <resultCode>00</resultCode>
  </header>
  <body>
    <items>
      <item>
        <course>3</course>
        <itemcntnts>매년 11월 11일 11시가 되면 부산에서1분간 사이렌이 울립니다. 6.25참전 유엔전사자의 희생과 헌신을 기억하는 순간, 『턴 투워드 부산(Turn Toward Busan) 유엔참전용사 국제추모식』 행사가 열리기</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20201106141515814_ttiel</main_img_n>
        <title>턴 투워드 부산(Turn Toward Busan)</title>
        <gugan>1</gugan>
        <uc_seq>1016</uc_seq>
        <cate1_nm>명소</cate1_nm>
        <name>턴투워드부산(한,영,중간,중번,일)</name>
        <lng>129.09766</lng>
        <place>유엔기념공원, 유엔평화기념관</place>
        <main_img_t>/uploadImgs/files/cntnts/20201106141515814_thumbL</main_img_t>
        <lat>35.127785</lat>
      </item>
      <item>
        <course>9</course>
        <itemcntnts>청정자연을 그대로 품은 부산치유의 숲에서 힐링하고 가세요~!
아홉산 자락에 넓게 자리한 부산치유의 숲은 부산 최초로 조성된 치유의 숲이랍니다. 체계적인 산림치유 프로그램을 운영하고 ?</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20200729150013892_ttiel</main_img_n>
        <title>부산치유의 숲</title>
        <gugan>1</gugan>
        <uc_seq>848</uc_seq>
        <cate1_nm>명소</cate1_nm>
        <name>부산치유의 숲(한, 영)</name>
        <lng>129.12955</lng>
        <place>부산치유의 숲</place>
        <main_img_t>/uploadImgs/files/cntnts/20200729150013892_thumbL</main_img_t>
        <lat>35.26948</lat>
      </item>
      <item>
        <course>3</course>
        <itemcntnts>오래전, 늦은 밤 부산항에 입항했던 외국의 선원들은 산 높은 곳까지 별처럼 반짝이는 화려한 야경에 감탄을 했다고 한다. 그리고 다음 날 그 아름다운 불빛들이 피란민들에 의해 만들어진 움?</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20200722140028489_ttiel</main_img_n>
        <title>부산의 옛 흔적을 찾아, 우암동 소막마을</title>
        <gugan>1</gugan>
        <uc_seq>838</uc_seq>
        <cate1_nm>명소</cate1_nm>
        <name>부산의 옛 흔적을 찾아, 우암동 소막마을</name>
        <lng>129.07597</lng>
        <place>우암동 소막마을</place>
        <main_img_t>/uploadImgs/files/cntnts/20200722140028489_thumbL</main_img_t>
        <lat>35.126194</lat>
      </item>
      <item>
        <course>4</course>
        <itemcntnts>100년의 추억이 담긴 송도. 그 시간 속에는 많은 사람들이 그리워하던 송도구름다리가 있습니다. 18년 만에 우리의 곁으로 다시 돌아온 송도용궁구름다리! 송도 바다를 조금 더 가까이 만날 수 ?</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20200717114921294_ttiel</main_img_n>
        <title>송도에서 구름 위를 느끼는 법</title>
        <gugan>1</gugan>
        <uc_seq>833</uc_seq>
        <cate1_nm>명소</cate1_nm>
        <name>송도용궁구름다리(한, 영, 중_간, 중_번)</name>
        <lng>129.02191</lng>
        <place>송도용궁구름다리</place>
        <main_img_t>/uploadImgs/files/cntnts/20200717114921294_thumbL</main_img_t>
        <lat>35.06194</lat>
      </item>
      <item>
        <course>6</course>
        <itemcntnts>사상생활사박물관은 근대 부산경제의 중심지였던 사상지역과 그 생활사를 소개하고 주민 간 소통을 이어가기 위해 건립되었다.

상설전시관은 낙동강과 함께 세월을 지나온 사상의 옛 모습과</itemcntnts>
<main_img_n>/uploadImgs/files/cntnts/20200102142920888_ttiel</main_img_n>
<title>주민들의 소통 공간, 사상생활사박물관</title>
<gugan>1</gugan>
<uc_seq>511</uc_seq>
<cate1_nm>명소</cate1_nm>
<name>사상생활사박물관</name>
<lng>128.97871</lng>
<place>사상생활사박물관</place>
<main_img_t>/uploadImgs/files/cntnts/20200102142920888_thumbL</main_img_t>
<lat>35.172</lat>
</item>
<item>
<course>3</course>
<itemcntnts>비어있던 건어물 위판장이 복합문화공간으로 변모했다. 남포동 건어물 도매시장 내 B4291이 바로 그것. 1층엔 남포조인트마켓과 B.archive가, 2층에는 커피를 직접 로스팅하는 카페가 입점해 있다.</itemcntnts>
<main_img_n>/uploadImgs/files/cntnts/20200102141841728_ttiel</main_img_n>
<title>전통시장에 부는 힙한 바람 B4291</title>
<gugan>2</gugan>
<uc_seq>509</uc_seq>
<cate1_nm>명소</cate1_nm>
<name>B4291</name>
<lng>129.03468</lng>
<place>B4291</place>
<main_img_t>/uploadImgs/files/cntnts/20200102141841728_thumbL</main_img_t>
<lat>35.096855</lat>
</item>
<item>
<course>3</course>
<itemcntnts>분명히 시간은 세월의 흐름을 재촉하고 있었을 텐데 이곳의 시간은 더디게만 흘렀나보다. 다닥다닥 붙은 낡고 좁은 집, 그 사이를 가로지르는 한 뼘 만 한 골목. 색다른 풍경이 레트로 감성을 ?</itemcntnts>
<main_img_n>/uploadImgs/files/cntnts/20200101164518953_ttiel</main_img_n>
<title>소막마을을 아시나요?</title>
<gugan>1</gugan>
<uc_seq>483</uc_seq>
<cate1_nm>명소</cate1_nm>
<name>우암동 소막마을</name>
<lng>129.07018</lng>
<place>우암동 소막마을</place>
<main_img_t>/uploadImgs/files/cntnts/20200101164518953_thumbL</main_img_t>
<lat>35.1256</lat>
</item>
<item>
<course>7</course>
<itemcntnts>지난 2002년 부산 아시안게임 경기장으로 만들어졌던 스포원파크. 아시안게임 당시 농구 예선 경기와 테니스, 사이클 경기가 열렸던 이곳은 아시안게임이 끝난 후 부산 시민과 함께하는 ‘개방</itemcntnts>
<main_img_n>/uploadImgs/files/cntnts/20191231201409836_ttiel</main_img_n>
<title>가족과 함께 룰루랄라 스포원파크</title>
<gugan>2</gugan>
<uc_seq>463</uc_seq>
<cate1_nm>명소</cate1_nm>
<name>스포원파크</name>
<lng>129.10487</lng>
<place>스포원파크</place>
<main_img_t>/uploadImgs/files/cntnts/20191231201409836_thumbL</main_img_t>
<lat>35.291504</lat>
</item>
<item>
<course>6</course>
<itemcntnts>이름에서 알 수 있듯 구름과 물이 좋기로 소문난 운수사, 그래서 수행하기 좋은 도량으로 천년이나 이어져 왔나보다.
하늘을 덮은 고목에서 뿜어 나오는 싱그러움이 산책로를 가득 채운다. 국?</itemcntnts>
<main_img_n>/uploadImgs/files/cntnts/20191231193736138_ttiel</main_img_n>
<title>운수사에 서면 낙동강이 내 품으로</title>
<gugan>2</gugan>
<uc_seq>459</uc_seq>
<cate1_nm>명소</cate1_nm>
<name>운수사</name>
<lng>129.01346</lng>
<place>운수사</place>
<main_img_t>/uploadImgs/files/cntnts/20191231193736138_thumbL</main_img_t>
<lat>35.18432</lat>
</item>
<item>
<course>6</course>
<itemcntnts>몸도 마음도 맑아지게 만드는 천년고찰 선암사가 백양산 숲 한가운데 고즈넉이 앉았다. 신라시대 원효대사가 창건하였다고 하니 그 오랜 세월을 가늠하는 것은 어렵지 않다.
조용하고 한적한</itemcntnts>
<main_img_n>/uploadImgs/files/cntnts/20191231193124555_ttiel</main_img_n>
<title>천년의 향기 선암사</title>
<gugan>2</gugan>
<uc_seq>458</uc_seq>
<cate1_nm>명소</cate1_nm>
<name>선암사</name>
<lng>129.02771</lng>
<place>선암사</place>
<main_img_t>/uploadImgs/files/cntnts/20191231193124555_thumbL</main_img_t>
<lat>35.176968</lat>
</item>
</items>
<numOfRows>10</numOfRows>
<pageNo>1</pageNo>
<totalCount>85</totalCount>
  </body>
</response>


2) [갈맷길주변맛집정보] 상세기능명세
   a) 상세기능정보

상세기능 번호
2
상세기능 유형
조회 (목록)
상세기능명(국문)
갈맷길주변맛집정보
상세기능 설명
① 갈맷길코스와 구간을 이용해 ② SEQ, 구분, 위치, 주소, 상태, 코스, 구간 등 ③ 갈맷길 주변의 맛집을 조회하는 기능
Call Back URL
http://apis.data.go.kr/6260000/fbusangmgtourinfo/getgmgfoodinfo
최대 메시지 사이즈
[16000] byte
평균 응답 시간
[187] ms
초당 최대 트랙잭션
[50] tps
b) 요청 메시지 명세

항목명(영문)
항목명(국문)
항목크기
항목구분
샘플데이터
항목설명
ServiceKey
인증키
100
1
인증키
(URL Encode)
공공데이터포털에서 발급받은 인증키
numOfRows
검색건수
4
1
10
검색건수
pageNo
페이지 번호
4
1
1
페이지 번호
resultType
JSON방식 호출
4
0
json
JSON방식으로 호출 시 파라미 resultType=json 입력
※ 항목구분 : 필수(1), 옵션(0), 1건 이상 복수건(1..n), 0건 또는 복수건(0..n)

c) 응답 메시지 명세

항목명(영문)
항목명(국문)
항목크기
항목구분
샘플데이터
항목설명
numOfRows
한 페이지 결과 수
4
1
10
한 페이지당 표출 데이터 수
pageNo
페이지 수
4
1
1
페이지 수
resultCode
결과코드
2
1
00
결과코드
resultMsg
결과메시지
50
1
OK
결과메시지
totalCount
데이터 총 개수
4
1
84
데이터 총 개수
name
관리를 위한 명칭
30
0
비상
관리를 위한 명칭
uc_seq
일련번호
5
0
973
일련번호
main_title
음식점명칭
50
0
비상
음식점명칭
addr1
주소
100
0
부산 사상구 강변대로 420-7
주소
addr2
주소2
100
0

주소2
cntct_tel
전화번호
15
0
051-326-8080
전화번호
usage_day_
이용가능시간
50
0
am 11:00 ~ am 00:00
이용가능시간
main_img_n
메인이미지
300
0
/uploadImgs/files/cntnts/20200819150153010_ttiel
비짓부산의 메인이미지
main_img_t
메인이미지의 썸네일
300
0
/uploadImgs/files/cntnts/20200819150153010_thumbL
비짓부산의 썸네일이미지경로
itemcntnts
소개글
4000
0
탁트인 낙동강 뷰와 아름다운 노을 인더스트리 얼과 빈티지 디자인을 접목한 공간으로, 조각 상과 올드카, 다양한 그림을 전시하여 갤러리 같은 느낌의 카페로, 빔프로젝트를 이용
소개글
course
코스
2
0
6
코스
gugan
구간
2
0
1
구간
lat
위도
50
0
35.12371
위도
lng
경도
50
0
128.96237
경도
※ 항목구분 : 필수(1), 옵션(0), 1건 이상 복수건(1..n), 0건 또는 복수건(0..n)
d) 요청/응답 메시지 예제

요청메시지
http://apis.data.go.kr/6260000/fbusangmgtourinfo/getgmgfoodinfo?ServiceKey=서비스키&numOfRows=10&pageNo=1
응답메시지
<?xml version="1.0" encoding="UTF-8"?><response>
  <header>
    <resultMsg>NORMAL_CODE</resultMsg>
    <resultCode>00</resultCode>
  </header>
  <body>
    <items>
      <item>
        <course>6</course>
        <itemcntnts>탁트인 낙동강 뷰와 아름다운 노을 인더스트리 얼과 빈티지 디자인을 접목한 공간으로, 조각 상과 올드카, 다양한 그림을 전시하여 갤러리 같은 느낌의 카페로, 빔프로젝트를 이용해 영화를 ??</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20200819150153010_ttiel</main_img_n>
        <cntct_tel>051-326-8080</cntct_tel>
        <gugan>1</gugan>
        <addr1>부산 사상구 강변대로 420-7</addr1>
        <addr2/>
        <uc_seq>973</uc_seq>
        <name>비상</name>
        <lng>128.96237</lng>
        <usage_day_>am 11:00 ~ am 00:00</usage_day_>
        <main_title>비상</main_title>
        <main_img_t>/uploadImgs/files/cntnts/20200819150153010_thumbL</main_img_t>
        <lat>35.12371</lat>
      </item>
      <item>
        <course>4</course>
        <itemcntnts>제과기능장인 오너파티쉐가 운영하는 제과점으로 새로운 메뉴들도 출시하고 오래된 메뉴들도 놓치지 않고 만들어 많은 종류의 빵을 하루에 두 번 굽는다고 한다. 대표 메뉴인 파네토네는 천??</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20200819141103473_ttiel</main_img_n>
        <cntct_tel>051-264-2089</cntct_tel>
        <gugan>2</gugan>
        <addr1>부산 사하구 다송로 17</addr1>
        <addr2/>
        <uc_seq>968</uc_seq>
        <name>아비앙또카페</name>
        <lng>128.98152</lng>
        <usage_day_>am 07:30 ~ pm 23:00</usage_day_>
        <main_title>아비앙또카페</main_title>
        <main_img_t>/uploadImgs/files/cntnts/20200819141103473_thumbL</main_img_t>
        <lat>35.065857</lat>
      </item>
      <item>
        <course>4</course>
        <itemcntnts>유명한 양식레스토랑인 디에이블의 분점으로, 가게 전체에서 보이는 멋진 바다풍경 속에서 특별한 식사를 할 수 있는 곳이다. 시그니처 메뉴인 피자는 페스츄리 도우를 사용해 촉촉한 것이 특</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20200819132345743_ttiel</main_img_n>
        <cntct_tel>051-231-9177</cntct_tel>
        <gugan>1</gugan>
        <addr1>부산 서구 충무대로 47 3층</addr1>
        <addr2/>
        <uc_seq>960</uc_seq>
        <name>디에이블</name>
        <lng>129.01715</lng>
        <usage_day_>am 11:00 ~ pm 22:00</usage_day_>
        <main_title>디에이블</main_title>
        <main_img_t>/uploadImgs/files/cntnts/20200819132345743_thumbL</main_img_t>
        <lat>35.076706</lat>
      </item>
      <item>
        <course>2</course>
        <itemcntnts>광안리해수욕장 앞 골목길에 위치한 아담한 이 가게는 국산 팥만을 사용하여 음식들을 만드는 팥전문점이다. 팥빙수와 단팥죽, 단팥빵이 유명한데, 특히 단팥빵의 인기가 높아 빵을 사가려는</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20200819131636744_ttiel</main_img_n>
        <cntct_tel>051-627-1026</cntct_tel>
        <gugan>2</gugan>
        <addr1>부산 수영구 남천동로 108번길 49</addr1>
        <addr2/>
        <uc_seq>959</uc_seq>
        <name>홍옥당</name>
        <lng>129.11392</lng>
        <usage_day_>am 10:00 ~ pm 22:00</usage_day_>
        <main_title>홍옥당</main_title>
        <main_img_t>/uploadImgs/files/cntnts/20200819131636744_thumbL</main_img_t>
        <lat>35.146893</lat>
      </item>
      <item>
        <course>6</course>
        <itemcntnts>22년의 전통을 가지고 있는 함흥냉면 전문점으로, 메뉴에 들어가는 모든 재료들을 직접 만든다. 고구마 전분 특유의 탄력과 쫄깃함을 가진 함흥식 냉면 사리가 특징이며, 진한 육수가 맛있는 ??</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20200820091029413_ttiel</main_img_n>
        <cntct_tel>051-363-5000</cntct_tel>
        <gugan>3</gugan>
        <addr1>부산 북구 금곡대로 21</addr1>
        <addr2/>
        <uc_seq>958</uc_seq>
        <name>함경면옥</name>
        <lng>129.00423</lng>
        <usage_day_>am 11:00 ~ pm 21:20</usage_day_>
        <main_title>함경면옥</main_title>
        <main_img_t>/uploadImgs/files/cntnts/20200820091029413_thumbL</main_img_t>
        <lat>35.21178</lat>
      </item>
      <item>
        <course>8</course>
        <itemcntnts>(구)고려제강의 공장을 개조하여 만든 복합문화공간 F1963에 입점한 테라로사커피팩토리는 손몽주 작가의 와이어를 이용한 설치 작품을 시작으로, 기존 공장의 오래된 물건들을 활용한 인테리?</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20200819173059093_ttiel</main_img_n>
        <cntct_tel>051-756-1963</cntct_tel>
        <gugan>2</gugan>
        <addr1>부산 수영구 구락로 123번길</addr1>
        <addr2/>
        <uc_seq>956</uc_seq>
        <name>F1963</name>
        <lng>129.11491</lng>
        <usage_day_>am 09:00 ~ pm 21:00</usage_day_>
        <main_title>F1963</main_title>
        <main_img_t>/uploadImgs/files/cntnts/20200819173059093_thumbL</main_img_t>
        <lat>35.176826</lat>
      </item>
      <item>
        <course>2</course>
        <itemcntnts>제주도에서 온 해장국전문점으로, 은근한 야채육수와 탑처럼 쌓인 담백한 제주산 돼지고기가 특징이다. 고명처럼 올라간 표고버섯과 고기를 육수에 잠기게 한 다음 간장소스에 샤브 샤브 처??</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20200819165944645_ttiel</main_img_n>
        <cntct_tel>051-756-5332</cntct_tel>
        <gugan>2</gugan>
        <addr1>부산 민락수변로7번길 60</addr1>
        <addr2/>
        <uc_seq>952</uc_seq>
        <name>탑해장</name>
        <lng>129.12698</lng>
        <usage_day_>am 08:00 ~ am 00:00</usage_day_>
        <main_title>탑해장</main_title>
        <main_img_t>/uploadImgs/files/cntnts/20200819165944645_thumbL</main_img_t>
        <lat>35.15513</lat>
      </item>
      <item>
        <course>6</course>
        <itemcntnts>금정산 끝자락의 개울 앞에 위치하는 오리고기전문점으로, 주인의 형제들이 직접 농사지은 재료를 사용하여 음식을 만들고 있다. 국내산 한약 재료를 넣고 푹 삶아 만든 백숙과 석쇠에 구운 ??</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20200819154234479_ttiel</main_img_n>
        <cntct_tel>051-332-4535</cntct_tel>
        <gugan>3</gugan>
        <addr1>부산 북구 산성로 100</addr1>
        <addr2/>
        <uc_seq>951</uc_seq>
        <name>심우촌</name>
        <lng>129.02373</lng>
        <usage_day_>am 10:00 ~ pm 22:00</usage_day_>
        <main_title>심우촌</main_title>
        <main_img_t>/uploadImgs/files/cntnts/20200819154234479_thumbL</main_img_t>
        <lat>35.24159</lat>
      </item>
      <item>
        <course>2</course>
        <itemcntnts>부산에서 가장 유명한 불고기전문점 중 한 곳으로, 30여년의 역사를 가지고 있다. 한우암소 등심을 사용하고 간장과 마늘을 베이스로 한 양념이 특징인 언양불고기가 대표메뉴로 다소 높은 가?</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20200819114726472_ttiel</main_img_n>
        <cntct_tel>051-754-1004</cntct_tel>
        <gugan>2</gugan>
        <addr1>부산 수영구 남천바다로 32</addr1>
        <addr2/>
        <uc_seq>950</uc_seq>
        <name>언양불고기부산집</name>
        <lng>129.11357</lng>
        <usage_day_>am 11:00 ~ pm 22:00</usage_day_>
        <main_title>언양불고기부산집</main_title>
        <main_img_t>/uploadImgs/files/cntnts/20200819114726472_thumbL</main_img_t>
        <lat>35.1479</lat>
      </item>
      <item>
        <course>2</course>
        <itemcntnts>빵을 만들 때 밀가루를 사용하지 않고 쌀가루만 사용하는 독특한 제과점으로, 소화가 잘돼 노인과 아이, 환자가 먹기에도 부담스럽지 않다. 특히 다이어트에 관심이 높은 셀러브리티가 좋아하</itemcntnts>
        <main_img_n>/uploadImgs/files/cntnts/20200819113644935_ttiel</main_img_n>
        <cntct_tel>051-623-3775</cntct_tel>
        <gugan>2</gugan>
        <addr1>부산 수영구 광안해변로 122</addr1>
        <addr2/>
        <uc_seq>947</uc_seq>
        <name>순살빵순쌀나라</name>
        <lng>129.11499</lng>
        <usage_day_>am 08:00 ~ am 01:00</usage_day_>
        <main_title>순살빵순쌀나라</main_title>
        <main_img_t>/uploadImgs/files/cntnts/20200819113644935_thumbL</main_img_t>
        <lat>35.14582</lat>
      </item>
    </items>
    <numOfRows>10</numOfRows>
    <pageNo>1</pageNo>
    <totalCount>84</totalCount>
  </body>
</response>



3) [갈맷길주변숙박시설정보] 상세기능명세
   a) 상세기능정보

상세기능 번호
3
상세기능 유형
조회 (목록)
상세기능명(국문)
갈맷길주변숙박시설정보
상세기능 설명
① 갈맷길코스와 구간을 이용해 ② SEQ, 구분, 위치, 주소, 상태, 코스, 구간 등 ③ 갈맷길 주변의 숙박지를 조회하는 기능
Call Back URL
http://apis.data.go.kr/6260000/fbusangmgtourinfo/getgmghotelinfo
최대 메시지 사이즈
[16000] byte
평균 응답 시간
[187] ms
초당 최대 트랙잭션
[50] tps
b) 요청 메시지 명세

항목명(영문)
항목명(국문)
항목크기
항목구분
샘플데이터
항목설명
ServiceKey
인증키
100
1
인증키
(URL Encode)
공공데이터포털에서 발급받은 인증키
numOfRows
검색건수
4
1
10
검색건수
pageNo
페이지 번호
4
1
1
페이지 번호
resultType
JSON방식 호출
4
0
json
JSON방식으로 호출 시 파라미 resultType=json 입력
※ 항목구분 : 필수(1), 옵션(0), 1건 이상 복수건(1..n), 0건 또는 복수건(0..n)


c) 응답 메시지 명세

항목명(영문)
항목명(국문)
항목크기
항목구분
샘플데이터
항목설명
numOfRows
한 페이지 결과 수
4
1
10
한 페이지당 표출 데이터 수
pageNo
페이지 수
4
1
1
페이지 수
resultCode
결과코드
2
1
00
결과코드
resultMsg
결과메시지
50
1
OK
결과메시지
totalCount
데이터 총 개수
4
1
175
데이터 총 개수
name
관리를 위한 명칭
30
0
연화리330 풀빌라 앤 호텔
관리를 위한 명칭
uc_seq
일련번호
5
0
830
일련번호
gbn
구분
50
0
호스텔
구분
place
장소
100
0
연화리330 풀빌라 앤 호텔
장소
addr1
주소
100
0
부산 기장군 기장읍 기장해안로 460
주소
addr2
주소2
100
0

주소2
cntct_tel
전화번호
15
0

전화번호
num_room
이용가능시간
50
0
24
이용가능시간
homepage_u
홈페이지
100
0
http://yeonhwari330.com/
홈페이지
course
코스
2
0
1
코스
gugan
구간
2
0
2
구간
lat
위도
50
0
35.21563
위도
lng
경도
50
0
129.223
경도
※ 항목구분 : 필수(1), 옵션(0), 1건 이상 복수건(1..n), 0건 또는 복수건(0..n)

d) 요청/응답 메시지 예제

요청메시지
http://apis.data.go.kr/6260000/fbusangmgtourinfo/getgmghotelinfo?ServiceKey=서비스키&numOfRows=10&pageNo=1
응답메시지
<?xml version="1.0" encoding="UTF-8"?><response>
  <header>
    <resultMsg>NORMAL_CODE</resultMsg>
    <resultCode>00</resultCode>
  </header>
  <body>
    <items>
      <item>
        <uc_seq>830</uc_seq>
        <grade_nm/>
        <lng>129.223</lng>
        <num_room>24</num_room>
        <course>1</course>
        <cntct_tel/>
        <addr1>부산 기장군 기장읍 기장해안로 460</addr1>
        <gugan>2</gugan>
        <addr2/>
        <name>연화리330 풀빌라 앤 호텔</name>
        <gbn>호스텔</gbn>
        <homepage_u>http://yeonhwari330.com/</homepage_u>
        <place>연화리330 풀빌라 앤 호텔</place>
        <lat>35.21563</lat>
      </item>
      <item>
        <uc_seq>829</uc_seq>
        <grade_nm/>
        <lng>129.20856</lng>
        <num_room>14</num_room>
        <course>1</course>
        <cntct_tel/>
        <addr1>부산 기장군 기장읍 기장해안로 26</addr1>
        <gugan>2</gugan>
        <addr2/>
        <name>타이드어웨이풀빌라</name>
        <gbn>호스텔</gbn>
        <homepage_u>http://www.tideaway.co.kr/</homepage_u>
        <place>타이드어웨이풀빌라</place>
        <lat>35.1821699999999</lat>
      </item>
      <item>
        <uc_seq>828</uc_seq>
        <grade_nm/>
        <lng>129.0353</lng>
        <num_room>100</num_room>
        <course>3</course>
        <cntct_tel>051-241-1051</cntct_tel>
        <addr1>부산광역시 중구 광복로67번길 8</addr1>
        <gugan>2</gugan>
        <addr2/>
        <name>로얄관광호텔</name>
        <gbn>관광호텔</gbn>
        <homepage_u/>
        <place>로얄관광호텔</place>
        <lat>35.09792</lat>
      </item>
      <item>
        <uc_seq>827</uc_seq>
        <grade_nm/>
        <lng>129.11403</lng>
        <num_room>12</num_room>
        <course>2</course>
        <cntct_tel/>
        <addr1>부산 수영구 남천바다로 31-1 AK빌딩 6층</addr1>
        <gugan>2</gugan>
        <addr2/>
        <name>제이스테이</name>
        <gbn>호스텔</gbn>
        <homepage_u>http://www.jstay.co.kr/default/</homepage_u>
        <place>제이스테이</place>
        <lat>35.148754</lat>
      </item>
      <item>
        <uc_seq>826</uc_seq>
        <grade_nm/>
        <lng>129.1153</lng>
        <num_room>11</num_room>
        <course>2</course>
        <cntct_tel/>
        <addr1>부산광역시 수영구 남천바다로33번길 47 (광안동)</addr1>
        <gugan>2</gugan>
        <addr2/>
        <name>더뷰 호스텔</name>
        <gbn>호스텔</gbn>
        <homepage_u>http://www.theview-hostel.com/ko/</homepage_u>
        <place>더뷰 호스텔</place>
        <lat>35.15049</lat>
      </item>
      <item>
        <uc_seq>825</uc_seq>
        <grade_nm/>
        <lng>129.19841</lng>
        <num_room>7</num_room>
        <course>1</course>
        <cntct_tel>1899-0306</cntct_tel>
        <addr1>부산 해운대구 송정중앙로6번길 118</addr1>
        <gugan>2</gugan>
        <addr2/>
        <name>송정스카이풀빌라</name>
        <gbn>호스텔</gbn>
        <homepage_u>http://sjskypool.com/fhtml/</homepage_u>
        <place>송정스카이풀</place>
        <lat>35.17934</lat>
      </item>
      <item>
        <uc_seq>824</uc_seq>
        <grade_nm/>
        <lng>129.2</lng>
        <num_room>5</num_room>
        <course>1</course>
        <cntct_tel/>
        <addr1>부산 해운대구 송정중앙로6번길 54</addr1>
        <gugan>2</gugan>
        <addr2/>
        <name>빌라 코트야드</name>
        <gbn>호스텔</gbn>
        <homepage_u>http://www.courtyard.kr/</homepage_u>
        <place>빌라 코트야드</place>
        <lat>35.1815069999999</lat>
      </item>
      <item>
        <uc_seq>823</uc_seq>
        <grade_nm/>
        <lng>129.15298</lng>
        <num_room>27</num_room>
        <course>2</course>
        <cntct_tel>051-746-2183</cntct_tel>
        <addr1>부산광역시 해운대구 해운대해변로197번길 14</addr1>
        <gugan>1</gugan>
        <addr2/>
        <name>캔버스블랙</name>
        <gbn>호스텔</gbn>
        <homepage_u>https://canvashostel.modoo.at/</homepage_u>
        <place>캔버스블랙</place>
        <lat>35.159363</lat>
      </item>
      <item>
        <uc_seq>822</uc_seq>
        <grade_nm/>
        <lng>129.19865</lng>
        <num_room>7</num_room>
        <course>1</course>
        <cntct_tel>0507-1468-0141</cntct_tel>
        <addr1>부산 해운대구 송정광어골로 15-1 2~4층</addr1>
        <gugan>2</gugan>
        <addr2/>
        <name>펜톤나인</name>
        <gbn>호스텔</gbn>
        <homepage_u>http://penton9.com/</homepage_u>
        <place>펜톤나인</place>
        <lat>35.17953</lat>
      </item>
      <item>
        <uc_seq>821</uc_seq>
        <grade_nm/>
        <lng>129.16983</lng>
        <num_room>260</num_room>
        <course>2</course>
        <cntct_tel>051-922-1000</cntct_tel>
        <addr1>부산광역시 해운대구 달맞이길 30 (중동. 엘시티)</addr1>
        <gugan>1</gugan>
        <addr2/>
        <name>(주)호텔롯데 시그니엘 부산</name>
        <gbn>관광호텔</gbn>
        <homepage_u>https://www.lottehotel.com/busan-signiel/ko.html</homepage_u>
        <place>(주)호텔롯데 시그니엘 부산</place>
        <lat>35.159912</lat>
      </item>
    </items>
    <numOfRows>10</numOfRows>
    <pageNo>1</pageNo>
    <totalCount>175</totalCount>
  </body>
</response>


에러코드
에러메시지
설명
1
APPLICATION_ERROR
어플리케이션 에러
10
INVALID_REQUEST_PARAMETER_ERROR
잘못된 요청 파라메터 에러
12
NO_OPENAPI_SERVICE_ERROR
해당 오픈API서비스가 없거나 폐기됨
20
SERVICE_ACCESS_DENIED_ERROR
서비스 접근거부
22
LIMITED_NUMBER_OF_SERVICE_REQUESTS_EXCEEDS_ERROR
서비스 요청제한횟수 초과에러
30
SERVICE_KEY_IS_NOT_REGISTERED_ERROR
등록되지 않은 서비스키
31
DEADLINE_HAS_EXPIRED_ERROR
기한만료된 서비스키
32
UNREGISTERED_IP_ERROR
등록되지 않은 IP
99
UNKNOWN_ERROR
기타에러
2. OpenAPI 에러 코드정리
