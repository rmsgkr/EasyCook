# easycook
### [ 개요 ]
+ 음식을 쉽게 요리해 먹을 수 있는 밀키트를 판매하는 쇼핑몰 사이트

### [ 프로젝트 요약 ]
+ 사이트 명 : easycook (이지쿡)
+ 프로젝트 기간 : 2020.09.28 ~ 2020.11.04 (38일)
+ 개발 인원 : 6명
+ 구현 담당 기능 : 프로젝트 빌드, 데이터베이스 설계&구현, 전체/상세 상품, 장바구니, 위시리스트, 주문, 결제시스템 구현

### [ 개발환경 ]
+ 언어 : JAVA 8 (MVC Model 2)
+ 프레임워크 : Spring Framework 4
+ 빌드 : Maven
+ 서버 : Apatch Tomcat 9.0
+ 개발툴 : Eclipse
+ Frond-end : HTML5, CSS3, JavaScript(jquery, ajax), Bootstrap
+ Back-end : Jsp&Servlet
+ DB : Oracle, Mybatis, JDBC
+ 형상관리 : Git, Github
+ API : JavaMail, OpenWeather, Kakao, Naver, i'mport

### [ E-R Diagram ]

![ERD](https://user-images.githubusercontent.com/69949473/99359436-6a90c000-28f2-11eb-935b-a8fc6b64f964.png)

### [ 프로젝트 설명 ]

+ Index

![index](https://user-images.githubusercontent.com/69949473/99361248-25ba5880-28f5-11eb-95f1-dc7a9a5735c5.png)

> 밀키트 쇼핑몰 웹사이트의 메인화면으로 공지사항/이벤트 슬라이드, 베스트 상품 추천, 타임세일과 각종 정보를 보여줍니다.
<br>

+ Product

![product](https://user-images.githubusercontent.com/69949473/99359595-ab88d480-28f2-11eb-8df7-536136a1471f.png)

> 상품명 검색을 통해 상품을 조회할 수 있는 검색기능과 등록되어있는 상품 전체 목록을 볼 수 있습니다. 상품 목록은 판매인기순, 낮은가격순, 높은가격순으로 정렬하여 볼 수 있고 찜하기, 장바구니담기, 상세보기가 가능합니다. 상품 상세 페이지에서 수량을 입력할 수 있고 장바구니에 담을 수 있습니다. 해당 제품의 구매가 완료된 사람은 리뷰를 등록할 수도 있게 구현하였습니다. 
<br>

+ Cart

![cart](https://user-images.githubusercontent.com/69949473/99359695-cc512a00-28f2-11eb-852b-af8b97cf50be.png)

> sql을 통해 각 상품별 수량과 가격이 합산되어 update되고, 장바구니에 없는 상품은 새롭게 insert됩니다. Bootstrap Modal로 개별 삭제가 가능하도록 구현했고 주문하기 버튼을 누르면 장바구니에 존재하는 상품들이 주문페이지로 넘어가게 됩니다. 
주문이 완료되면 장바구니는 전체 삭제되도록 했습니다. 
<br>

+ Order

![order](https://user-images.githubusercontent.com/69949473/99359778-ebe85280-28f2-11eb-8778-eaafcf7509a9.png)

> 주문하는 클라이언트의 정보와 총금액이 넘어옵니다. 
쿠폰과 적립금의 중복사용을 막았고 사용가능한 쿠폰과 적립금을 보여줍니다.
이 과정에서 쿠폰/적립금 사용여부를 체크하여 환불시에 적용할 수 있도록 했습니다.
결제하기 버튼을 누르면 결제페이지로 넘어가게 됩니다.
<br>

+ Payment

![payment](https://user-images.githubusercontent.com/69949473/99359817-f7d41480-28f2-11eb-800b-c1ea3f754316.png)

> i'mport API를 이용하여 결제창을 띄웁니다. 쿠폰/적립금, 배송비가 적용된 최종 금액으로 결제되며 여러가지 결제방식을 제공합니다. 
<br>
