# Java final project Candidate
* 외부파일 읽고 쓰기, 스레드 적용, 외부 라이브러리 
## 1번 후보 : 그냥 하고 싶은 오늘의 운세 / 컨펌 전
### 프로그램 실행 전에 args에 생일을 지정해 주면 그 생일에 맞는 오늘의 운세와 추천 아이템, 추천 색, 별자리 별 운 순위를 알려줍니다.
### 동기
- 인터넷에 돌아다니는 오늘의 운세가 너무 바보같아 보여서 만듭니다.
- **이 프로그램만 있으면 나도 운세왕! 점쟁이 하기 참 쉽죠?**

### 프로그램 개요
#### 추천 아이템, 추천 색, 오늘의 운세 도움말이 들어있는 csv파일을 읽어오는 객체
* 각각 따로 파일이 들어있다.
#### 오늘의 운세 도움말을 일일히 작성하기 귀찮으므로 파트별로 나누어 조립한다. 이를 담당하는 클래스.
#### args로 입력된 생일을 사용가능한 형태로 변형해주는 클래스.
* 생일을 1월 1일을 1로, 12월 31일을 366일로 하는 정수타입으로 변환한 뒤 별자리 타입으로 바꾸어준다.
#### 생일에 따른 오늘의 운세를 랜덤으로 지정해 주는 클래스
* 이 때 seed는 오늘 날짜로 한다. 이유는 별 거 없고 이달의 운세, 올해의 운세보다 오늘의 운세가 더 인기 많아보여서.
#### 출력담당 클래스
* 초기 설정 값을 따라 해당 생일의 오늘의 운세를 실행창에 출력.
* 인터넷에 퍼나르기 쉽게 모든 별자리의 운세를 txt 파일로 변환하여 출력.
-----
* GUI를 예쁘게 꾸밀 수 있다면 위젯 형식으로 만들어서 어플 올리고 싶습니닼ㅋㅋㅋ 이런 거 좋아하는 인간들이 많더라고요.
* 이스터에그로 황도 12궁 체제에서 황도 13궁 체제로 바꾸는 기능을 넣고 싶습니다.(뱀주인자리 포함)<br/><br/>

## 2번 후보 : 그냥 하고 싶은 정렬 별 과정을 보여주는 웹사이트(?) / 컨펌 전
### 클라이언트가 서버에 접속해서 해당 정렬로 다음 문자열을 정렬해라 하면 정렬과정을 출력하여 클라이언트 화면에 보여줍니다.
### 동기
* 데이터 구조 숙제할 때 이런 사이트를 못 찾아서 답지 3번 갈아엎었습니다.

### 프로그램 개요
#### 클라이언트 전반
* 서버에 뭐 해조 하는 기능이 있어야 합니다.
#### 클라이언트 스레드
* 서버에서 날아온 결과 값을 처리
#### 서버 전반
* 클라이언트 별로 서버 스레드를 하나 개설해줍니다.
#### 서버에서 소트 전문으로 하는 애
* 일단 구현할 수 있는 모든 종류의 소트를 method로 가짐
* 한번 내용물을 swap할 때 마다 클라이언트에 스윽 하고 넘겨줌.
#### 서버 스레드<br/><br/>
* 클라이언트에서 들어온 명령에 따라 소트전문의 적절한 메소드를 호출하여 클라이언트에 들려줍니다.

## 3번 후보 : 그냥 주어진 과제를 한다.
### 힝ㅠ


## 마감일 : **2019년 6월 18일 22시**
--------
### ♟️ 