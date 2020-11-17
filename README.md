# easycook
### 개요
+ 음식을 쉽게 요리해 먹을 수 있는 밀키트를 판매하는 쇼핑몰 사이트

### 프로젝트 요약
+ 사이트명 : easycook (이지쿡)
+ 프로젝트 기간 : 2020.09.28 ~ 2020.11.04 (38일)
+ 인원 : 6명
+ 구현 담당 기능 : 프로젝트 빌드, 데이터베이스 설계&구현, 전체/상세 상품, 장바구니, 위시리스트, 주문, 결제시스템 구현

### 개발환경
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

### E-R Diagram
![ERD](https://user-images.githubusercontent.com/69949473/99359436-6a90c000-28f2-11eb-935b-a8fc6b64f964.png)

### 프로젝트 설명

#### index
![image](https://user-images.githubusercontent.com/69949473/99359535-94e27d80-28f2-11eb-9bd1-b1f86bd0d389.png)
> 회원가입 화면에서는 AJAX를 사용하여 아이디 중복체크와 비밀번호 일치여부, 비밀번호 자리수 제한 등을 구현하였고 다음주소 API를 사용하여 우편번호와 주소를 가져왔습니다. 회원가입을 하면 입력한 이메일로 인증링크를 보내 인증을 한 회원만 로그인을 가능하도록 하였습니다.
<br>

#### 아이디, 비밀번호찾기
![seekAuth](https://user-images.githubusercontent.com/48157259/98440175-82ba4f80-213a-11eb-86ba-a667854c83df.png)
> 아이디찾기 : 가입할 때 입력한 이메일 또는 휴대폰번호 2가지 방법을 라디오박스를 사용하여 사용자가 선택해 아이디를 찾을 수 있도록 구현하였습니다. <br>
> 비밀번호찾기 : 가입할 때 입력한 이메일을 입력하며 일치하면 인증번호를 전송해 입력시키면 비밀번호 변경을 통해 재설정하여 로그인할 수 있도록 구현하였습니다. 인증번호는 쿠키를 통해 10분간만 유효하도록 설정하였습니다.
<br>

#### Member
![admin_member](https://user-images.githubusercontent.com/48157259/98440637-315f8f80-213d-11eb-8211-23b0e1ad4efa.png)
> 가입한 회원목록과 탈퇴한 회원목록을 표시하였습니다. 각 회원의 주문내역을 확인할 수 있으며 최근구매일자와 총구매금액도 계산하여 나타나도록 구현하였습니다.
<br>

#### Product
![admin_product](https://user-images.githubusercontent.com/48157259/98440697-7be10c00-213d-11eb-9395-92dbe058c3d4.png)
> 이지쿡 상품인 밀키트의 상품을 등록, 조회, 수정, 삭제할 수 있도록 구현하였습니다. 상품등록화면에서는 각 카테고리(한식-10, 중식-20 등)에 따른 일련번호를 상품번호로 부여하였는데 이 과정에서 AJAX통해 상품의 개수를 카운트하여 자동으로 다음번호에 해당하는 상품번호가 생성되도록 구현하였습니다. 재고관리에서도 새 창을 띄워 수정 창을 띄웠고 AJAX를 통해 재고를 업데이트함과 동시에 본래의 브라우저창이 새로 고침 되도록 만들었습니다.
<br>

#### Order
![admin_order](https://user-images.githubusercontent.com/48157259/98440781-088bca00-213e-11eb-9723-7028d8ecd730.png)
> 고객이 주문한 내역을 표시하였습니다. 주문상세보기를 통해 해당 주문번호의 상세주문내역도 확인할 수 있으며 실제 배송을 보낼수 있는 것을 고려하여 배송상태를 관리자가 직접 통제해 주문완료->배송중->배송완료의 과정을 진행하도록 만들었습니다. 주문완료 상태에서는 고객이 주문취소를 할 수 있으며 배송완료 상태에서는 상품반품과 리뷰쓰기가 가능하도록 하였습니다.
<br>

#### Notice, Event, Coupon
![admin_notice](https://user-images.githubusercontent.com/48157259/98440849-894ac600-213e-11eb-9f7b-369e6e1fc5e9.png)
> 관리자모드에서 공지사항과 이벤트를 작성, 수정, 삭제할 수 있습니다. 쿠폰은 관리자가 등록한 후 등록된 쿠폰번호를 통해 이벤트를 작성할 때 콤보상자로 선택할 수 있도록 하여 이벤트와 쿠폰이 1:1 매핑되어 고객이 직접 이벤트 게시판에서 발급받을 수 있도록 하였습니다.
<br>

#### 오늘딜, review
![today](https://user-images.githubusercontent.com/48157259/98441039-c9f70f00-213f-11eb-9667-4eafb92b01d4.png)
> 오늘딜 : 매일 상품 하나를 등록하여 할인해주는 오늘딜을 구현하였습니다. DB에 상품번호와 할인날짜를 등록해 놓고 불러오며 남은 시간은 자바스크립트를 통해 표시하였습니다. 그 아래는 화살표를 눌러 바로 할인상품의 제품상세페이지가 출력되도록 하여 빠르게 구매할 수 있도록 하였습니다.    
> review : 구매자가 마이페이지 주문내역에서 리뷰를 남기면 제품상세 페이지 하단에 해당 상품의 리뷰가 표시되도록 하였습니다. 구매자가 매긴 평점은 평균 평점이 계산되어 별점 아이콘으로 시각적으로 확인할 수 있도록 구현하였습니다.
<br>
