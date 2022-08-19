# <img src = "https://github.com/songjeongwoo/metadx/blob/main/src/main/resources/static/res/fileImg.png?raw=true" width = "30" height = "30"> MetaDX : 보안 자료실

`2022.08.08 ~ 2022.08.19`
>'보안 자료실'은 KT DS 직원들이 외부에서도 사용할 수 있는 암호화된 파일 공유 서비스 입니다.

## 조원 소개
`MetaDX 팀`
>  김경준, 김동민, 김혜원, 송정우, 이성주

## 1. 개발 배경 및 목적

<img src = "https://github.com/songjeongwoo/metadx/blob/main/src/main/resources/static/res/basicDownload.PNG?raw=true" width = "600rem" height = "180rem">

#### AS-IS

> - 중요 문서의 외부 유출 가능성이 높아 사내망에서만 자료 접근이 가능하다. 따라서 외근, 급한 용무가 발생하였을 때 빠르게 문서 공유가 불가능해 불편함이 증가하고 있다.
> - 그룹메일로 사외망에서도 이메일 접속이 가능하지만,
막상 중요한 자료에는 접근이 불가능하다는 문제가 제기 되고 있다.

#### TO-BE
> - 외부망에서도 인증(캡챠, 인증 번호)된 사용자만 자료 공유 가능
>  - 문서 암호화 및 인증 3번 이상 실패 시 계정 차단으로 보안 강화
>  - 업/다운로드 시 사용자 관련 로그를 저장하여 문서 외부 유출 관리
>  - 타 디바이스에서도 쉽게 문서 공유 가능

## 2. 기능

#### 서비스 주요 기능

##### 1) 파일 업/다운로드 시
> - 파일 업로드 시 비밀번호 입력을 받아 파일의 비트를 변조하는 방식으로 사내 문서의 기밀 유지 가능
> - 파일 업로드시 메인 서버에 uuid_파일명.dat 파일로 저장됨
> - 캡챠를 이용하여 실제 사용자인지 판별
> - 해당 파일 관련 로그(시간, 사용자 정보 등)를 저장하여 문서 외부 유출 관리

##### 2) 인증 실패 시 계정 잠금
> - 캡챠 인증 3회 실패 시 공유 권한 제한
> - 파일 비밀번호 인증 3회 실패시 다운로드 권한 제한

##### 3) 데이터베이스
> - 트리거 생성 : 인증을 3회 실패한 계정의 경우 해당 계정이 잠기면서 잠금 내역을 자동으로 DB에 저장
> - 파일 업로드 : *.txt , *.exe 파일 업로드 제한

##### 4) 메일 인증(SMTP)
> - 회원가입, 비밀번호 찾기 시 이메일 인증을 통해 보안 강화

##### 5) 게시판 CRUD(등록, 조회, 수정, 삭제)
> - 게시판 페이지 페이징
> - 인증 여부에 따라 버튼 활성화, 비활성화

##### 6) 관리자 페이지
> - 월별 파일 다운로드, 월별 계정 차단 통계
> - 계정 잠금 해제 기능

##### 7) 로그인
> - 사용자 권한에 따른 접근 권한 설정

##### 8) 캡챠 인증
> - 숫자, 글꼴, 속성들을 랜덤으로 이미지를 생성하여 사용자가 로봇인지 사람인지 판별 할 수 있게 함<br>
>   예시)
# <img src = "https://github.com/songjeongwoo/metadx/blob/main/src/main/resources/static/res/captchaImage.png?raw=true" width = "500rem" height = "400rem" >

## 3. ERD
# <img src = "https://github.com/songjeongwoo/metadx/blob/main/src/main/resources/static/res/ERD.png?raw=true" width = "900rem" height = "450rem" >

## 4. 시스템 구성도
# <img src = "https://github.com/songjeongwoo/metadx/blob/main/src/main/resources/static/res/%EC%8B%9C%EC%8A%A4%ED%85%9C%EA%B5%AC%EC%84%B1%EB%8F%84.PNG?raw=true" width = "900rem" height = "450rem" >

## 5. 개발 일정
# <img src = "https://github.com/songjeongwoo/metadx/blob/main/src/main/resources/static/res/%EA%B0%9C%EB%B0%9C%EC%9D%BC%EC%A0%95.PNG?raw=true" width = "900rem" height = "450rem" >

## 6. 사용 기술
# <img src = "https://github.com/songjeongwoo/metadx/blob/main/src/main/resources/static/res/%EC%82%AC%EC%9A%A9%EA%B8%B0%EC%88%A0.PNG?raw=true" width = "900rem" height = "450rem" >

