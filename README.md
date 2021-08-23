# Final_WebProject

#### :link: 프론트엔드 - [Tracycle_WebProject_Front](https://github.com/eoc940/Tracycle_WebProject_Front)
#### :link: AI - [Tracycle_Ai](https://github.com/eoc940/Tracycle_Ai)

<br>

### :computer: 개발환경
---
- 기본 환경 
  - IDE : Eclipse
  - OS : Windows
  - Git
- 웹서비스 개발환경
  - Java 1.8(openjdk)
  - Spring Boot 2.5.2
  - Maven
  - MySQL
- Dependency
  - mybatis
  - jjwt

<br>

### :point_right: 요구사항 명세서
---
서비스(메뉴) | ID | 기능 설명 
-------------|----|----------
마이페이지 | Mem-001 | 닉네임, 주소 수정
마이페이지 | Mem-002 | 내가 작성한 게시글 보기/선택 이동
마이페이지 | Mem-003 | 내가 작성한 댓글 보기/선택 이동
마이페이지 | Mem-004 | 회원탈퇴
게시글 상세페이지 | Bo-001 | 게시글 + 사진 작성
게시글 상세페이지 | Bo-002 | 게시글 수정
게시글 상세페이지 | Bo-003 | 게시글 삭제
게시글 상세페이지 | Bo-004 | 댓글 작성(비밀 댓글 옵션)
게시글 상세페이지 | Bo-005 | 게시글 상세내용 출력
게시글 리스트페이지 | Bo-006 | 제목/작성자 리스트로 출력(사진과 함께)
게시글 리스트페이지 | Bo-007 | 제목/내용/작성자/지역/품목 검색
게시글 리스트페이지 | Bo-008 | 클릭시 이전/다음 페이지로 이동, 현재 페이지 번호 출력
이미지 인식 | Img-001 | 폐기물 사진 업로드(지역구 선택) 
이미지 인식 | Img-002 | 이미지 인식 결과 출력(딥러닝) - 수수료 가격
이미지 인식 | Img-003 | 접수 페이지, 전화안내, 게시판 글 작성 연결(이미지 함께)
폐기물 배출량 | Ch-001 | 전국 폐기물 배출량 차트 출력
해수면 및 기온 변화 | Ch-002 | 세계 해수면 및 기온 변화 차트 출력
해수면 및 기온 변화 | Ch-003 | (국내) 전국 평균 기온 변화 히트맵 출력

### :books: 아키텍쳐 구조
---
![image](https://user-images.githubusercontent.com/67304980/130406197-821d5e5d-aee2-4f14-996f-b17f520751e3.png)
- Spring Boot, Flask 서버는 Restful Service로 구현
- 요구사항 명세서의 '이미지 인식' 기능들만 Flask에서 구현, 나머지 기능들은 Spring Boot에서 구현
- Front, Spring Boot, Flask 서버들을 Docker image로 만든 후 AWS EC2에서 Docker-Compose를 통해 배포

![image](https://user-images.githubusercontent.com/67304980/130407134-554f42d1-c8a2-4173-bb8a-91da15835a7a.png)
- Presentation, Service, Persistent, Mybatis 로 레이어를 분할
- Util에는 jwt 관련 클래스와 이미지 이름 변환 클래스로 구성

<br>

### :memo: DB 설계
---
![image](https://user-images.githubusercontent.com/67304980/130407747-8efb2ef3-4fe9-450a-82b9-f7887ce3c3cc.png)
![image](https://user-images.githubusercontent.com/67304980/130407808-48111070-6d5b-489f-82be-5b531ccfa084.png)
- DB 정규화를 통해 7개의 테이블로 분리

<br>

### :notebook: 개선점
---
- 개발 환경
  - Intellij로 전환
- 기능 추가
  - 비밀번호 암호화 구현
  - Spring Security + Redis를 이용한 refresh token
  - 배포 자동화
- 기술 적용
  - Spring Security
  - Redis
  - MSA Architecture
  - Nginx
  - Jenkins

<br>
  
### :family: Contributors
--- 
- [Cloud0720](https://github.com/Cloud0720)
- [EunchongJeong](https://github.com/EunchongJeong)
- [iceman-brandon](https://github.com/iceman-brandon)
- [Koartifact](https://github.com/Koartifact)
- [SS0mmy](https://github.com/SS0mmy)
- [Suziny91](https://github.com/Suziny91)
- [sxxzin](https://github.com/sxxzin)



 
 
 
 
