# springboard
<a href="http://aladin.kr/p/TedbB">김인우, 『스프링 부트 시작하기』, 프로그래밍 인사이트</a> - 실습

Spring Boot + Spring Jpa + MySql(or H2 in-memory)

HTML페이지와 CSS는 교재 자료를 사용했습니다.

### 실행방법 
#### MS Windows
./gradlew.bat build

h2 in-memory 실행 : java -jar "-Dspring.profiles.active=h2" .\build\libs\springboard-0.0.1-SNAPSHOT.jar
MySql 실행 : java -jar "-Dspring.profiles.active=mysql,pass" .\build\libs\springboard-0.0.1-SNAPSHOT.jar

### 과제
<del>간단한 게시판 구현</del> </br>
<del>로깅</del></br>
AOP 사용</br>
예외 처리</br>
파일 업&다운로드</br>
RESTful</br>
Spring Data Jpa</br>

스프링 프로파일</br>

### <a href="https://github.com/sb33333/springboard/blob/master/reference.txt">참고자료</a>
