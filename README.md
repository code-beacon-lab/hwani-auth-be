# pjt-boilerplate
기본 로그인 보일러플레이트 프로젝트

## branch
- develop : 개발 버전
- feature : 특정 기능

## recipe
### 1. spring boot에서 security 적용하기
  - [X] Maven :  `pom.xml`에 이하와 같이 추가 한다.
    ```xml
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <scope>test</scope>
    </dependency>
    ```
  - dependency를 적용하기만 해도, 기본적인 security 설정이 완료된다.
  - 기본 설정이 된 경우 애플리케이션을 실행하면 기본적인 로그인 창이 뜬다.
### 2. security 설정 클래스 만들기
  - [X] `WebSecurityConfigurerAdapter`을 구현한 클래스를 만든다.
### 3. csrf 비활성화 하기
  - 설정 클래스에서 `configure(HttpSecurity)` 메소드를 오버라이드 하고
  -  파라미터로 넘어온 `HttpSecurity` 에서 `csrf().disable()` 메소드를 호출해 준다.
  - [ ] CSRF란?
  - [ ] https://okky.kr/article/396206
