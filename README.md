# petbreedding

# Petbreedding
## [펫브리띵 바로 가기](http://112.221.156.36:8090/petbreedding/) 
<!--
## [시연 영상 바로 보기](https://youtu.be/ZX5bDemHHXQ) 
-->
##### 팀원 : 곽서현(조장), 김세훈, 유해니, 이승연, 이은혜
---
## Contents
1. [프로젝트 소개](#프로젝트-소개)
2. [개발환경](#개발환경)
3. [프로젝트 기능구현](#프로젝트-기능구현)
4. [주요기능](#주요기능)
5. [Document](#Document)
---
## 프로젝트 소개
- 동물병원, 미용실 예약을 한 곳에서 할 수 있는 플랫폼
- 마케팅, 매출 정산 등을 펫브리띵이 대신 해줌으로서 제휴한 업체들은 고객에게 집중해 좀 더 나은 서비스를 제공
- 고객과 업체가 직접 통화할 필요 없이 간편하게 문의할 수 있는 채팅 서비스 제공
---
## 개발환경

|Category|Detail|
|:--:|:--:|
|FrontEnd|HTML5, JS, CSS3, JQuery|
|BackEnd|Java(JDK 1.8), Servlet, JSP, MyBatis|
|OS|Windows 10, MacOS|
|Libray|Apache Commons FileUpload, Imgscalr|
|API|Naver Login, Kakao Login, Coolsms, CKeditor5, I'mport, HightChart|
|IDE|Eclipse, VisualStudio, Spring Tool Suite|
|Server|Tomcat(v8.5)|
|Document|Google Drive, ERDCloud|
|CI|Github|
|DateBase|SQL Developer, Oracle(11g)|
---
## 프로젝트 기능구현
- 곽서현
  - 로그인, 예약, 결제, 찜
- 김세훈
  - 포인트, 게시판, 문의
- 유해니
  - 매장, 메뉴, 지도
- 이승연
  - 마이펫, 울트라콜, 통계
- 이은혜
  - 실시간 채팅, 알림


## 주요기능
**1. 메인페이지**<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126436253-edea3eee-03c8-4e73-a8d0-718a5ce23ca3.gif" /></left><br>
**2. 회원가입**<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126441350-75397007-3cce-40bf-a00f-ca33a285bd01.gif" /></left><br>
- 이메일, 닉네임, 핸드폰번호는 ajax를 사용해, DB까지 다녀오며 중복 검사를 진행함.
- 이름을 제외하고는 유효성 체크를 진행함.

**3. 강아지MBTI**<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126446946-06e4851b-0da2-4ca6-b8bc-8713e63b624f.gif" /></left><br>
**4. 리스트조회**<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126447132-bcb93d8e-ee75-4d57-bd8b-d36158155cdd.gif" /></left><br>
- 최신순, 인기순, 리뷰순 및 지도와 키워드 검색

**5. 예약**<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126448049-3f086f5f-5b9e-4a56-8ed0-41a28d95e86a.gif" /></left><br>
- datepicker를 사용해 캘린더 구현. 
- 주휴일 테이블을 ajax로 다녀오며, 해당 매장의 주휴일을 조회해 datepicker에 입력

**6. 결제**<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126448145-9fc4c591-79e1-43a4-8d0e-c8b6acc0d144.gif" /></left><br>
- 아임포트api를 사용
 
**7. 알림**<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126448425-9076024a-391f-4b43-9d4e-b9afcdb7b581.gif" /></left><br>

**8. 채팅**<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126448425-9076024a-391f-4b43-9d4e-b9afcdb7b581.gif" /></left><br>

**7. 울트라콜**<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126450353-9f5ae46e-4361-4c82-8812-f667a7be5db3.gif" /></left><br>

**8. 예약조회**<br>
- 사용자예약조회<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126453414-0d618aa3-a60e-4cee-aa0e-3770b152eb8e.gif" /></left><br>
- 사업자예약조회<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126453438-52ad199d-13ed-4b68-927b-4bd1e32c37f2.gif" /></left><br>

**9. 반려동물**<br>
- 반려동물등록<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126453677-0406c347-9ce0-4458-a651-d3e47aada53c.gif" /></left><br>

**10. 찜하기**<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126453812-f23c8e07-e7bc-4e9d-adf6-d6db48c1cec0.gif" /></left><br>

**11. 게시판**<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126453812-f23c8e07-e7bc-4e9d-adf6-d6db48c1cec0.gif" /></left><br>

**12. 그래프**<br>
<left><img src="https://user-images.githubusercontent.com/79631070/126454268-356f6f29-e072-418b-9b2b-c7537339ecec.gif" /></left><br>

- 뉴스 플로팅 메뉴 제공(Cryptonews API 사용)
- 표, 차트로 주요 코인 실시간 조회(bithumb, upbit, Trading View API 사용)
- BTMI, BTAI 지수 조회(Highcharts API 사용)
- 커뮤니티 인기 게시글 조회


---
## Document
### PPT
[Petbreedding.pdf](https://github.com/Claver-pickle/Petbreedding/files/6852813/Petbreedding.pdf)
### 1. 개발 일정
![개발일정](https://user-images.githubusercontent.com/64541839/126419285-0ef90abd-758b-4abd-a7da-9d4717d42642.png)
### 2. 유스케이스
#### 회원<br>
![UserUseCasePpt](https://user-images.githubusercontent.com/64541839/126423456-1889013a-858d-4ab1-93e4-35c0f61451fb.gif)
#### 비회원<br>
![Usecase비회원](https://user-images.githubusercontent.com/64541839/126426994-0907dfcf-e6a0-4b4f-9220-75fe83c9c2d2.png)
#### 비즈니스파트너<br>
![BpUseCase](https://user-images.githubusercontent.com/64541839/126427330-de4324d6-5818-4f3a-ba9c-339e09ef436d.gif)
#### 관리자<br>
![AdUseCase](https://user-images.githubusercontent.com/64541839/126427368-4afdc528-7b4f-4e50-8bc4-ef9f919ce794.gif)
### 3. ERD
![erd](https://user-images.githubusercontent.com/78994909/126428894-1e80a296-51e3-45d7-8422-e1d942c058ff.png)
### 4. 요구사항 정의서
[요구사항 정의서 원본 파일](https://github.com/Claver-pickle/Petbreedding/files/6852750/default.xlsx)
![요구사항 정의서](https://user-images.githubusercontent.com/64541839/126429477-0aeed4e2-e691-467a-99cf-ceee4e11b2b9.png)
### 5. 테이블 정의서
[테이블 정의서 원본 파일](https://github.com/Claver-pickle/Petbreedding/files/6853063/1.0.docx)
![테이블 정의서](https://user-images.githubusercontent.com/64541839/126436304-34d56524-5ae1-4d5d-8fdb-8f9c33381bba.png)
### 6. 클래스 다이어그램
[클래스 다이어그램 전체 이미지](https://github.com/Claver-pickle/Petbreedding/files/6853101/default.zip)
![admin](https://user-images.githubusercontent.com/64541839/126436756-64984e64-ccf8-4236-99d7-9583b9fa7841.jpg)
### 7. 화면 설계서
#### 사용자<br>
[화면 설계서 사용자 pdf 파일](https://github.com/Claver-pickle/Petbreedding/files/6853281/-.1.pdf)
![화면설계서 유저1](https://user-images.githubusercontent.com/64541839/126441868-4395b213-225d-4650-a0e5-71111a1df8ae.png)
![화면설계서 유저2](https://user-images.githubusercontent.com/64541839/126442096-9362d46e-9cc1-4c0e-8a5a-7d9eb9c8e34d.png)
![사용자1](https://user-images.githubusercontent.com/64541839/126444514-9b83beca-dc9e-4c53-abb6-e92259cd6f6c.png)
![사용자2](https://user-images.githubusercontent.com/64541839/126444744-05d6c90d-4754-4840-81ab-3c897f943111.png)
#### 비즈니스파트너<br>
[화면 설계서 비즈니스 파트너 pdf 파일](https://github.com/Claver-pickle/Petbreedding/files/6853281/-.1.pdf)
![화면설계서 사업자1](https://user-images.githubusercontent.com/64541839/126443107-f7b5ad18-6735-4074-827c-e15b8963dd0b.png)
![사업자6](https://user-images.githubusercontent.com/64541839/126443168-a8b0466e-af0f-41ff-be01-64d948f91f33.png)
![사업자5](https://user-images.githubusercontent.com/64541839/126443217-c587bd4f-f64b-4803-99dd-4b2b24814d2e.png)
![사업자4](https://user-images.githubusercontent.com/64541839/126443254-39c9e27b-61e3-4236-95d5-9d17c5798f6b.png)
![사업자2](https://user-images.githubusercontent.com/64541839/126443289-ab4e3c78-cbd2-4ca3-b7d9-43b4cbb9ab09.png)
![사업자3](https://user-images.githubusercontent.com/64541839/126443320-77fbf549-8078-482c-9410-383f1d0cbb7a.png)
#### 관리자<br>
[화면 설계서 관리자 pdf 파일](https://github.com/Claver-pickle/Petbreedding/files/6853281/-.1.pdf)
![관리자1](https://user-images.githubusercontent.com/64541839/126443909-61692000-5ec7-4e70-ad96-8ab20ba22e90.png)
![관리자2](https://user-images.githubusercontent.com/64541839/126443947-fb6aa58f-94e0-4859-8dcf-7d36353d7378.png)
![관리자3](https://user-images.githubusercontent.com/64541839/126443976-80c71f4e-353d-4524-af9b-00f3a89e7556.png)
