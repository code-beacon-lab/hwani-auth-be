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
  - [X] `WebSecurityConfigurerAdapter`을 상속한 클래스를 만든다.
  - `WebSecurityConfigurerAdapter`의 `init()` 메소드는 아래와 같다.
    ```java
    @Override
    public void init(WebSecurity web) throws Exception {
        HttpSecurity http = getHttp();
        web.addSecurityFilterChainBuilder(http).postBuildAction(() -> {
            FilterSecurityInterceptor securityInterceptor = http.getSharedObject(FilterSecurityInterceptor.class);
            web.securityInterceptor(securityInterceptor);
        });
    }
    ```
    - 여기서 호출되는 `getHttp()` 메소드에서 `HttpSecurity`클래스의 인스턴스가 생성된다.
    - 자동으로 완료되는 기본적인 보안 설정은 이 `getHttp()` 메소드에서 이루어진다.
      - 이 메소드는 마지막으로 동일 클래스의 `configure(this.http)`를 호출하는데, 따라서 이 `configure(HttpSecurity)` 메소드를 오버라이드 했을 때, 원하는 설정을 커스터마이징 할 수 있게 되는 것이다.  
  - 이때 생성된 `HttpSecurity` 타입의 `http` 멤버 변수에서 인가와 인증에 대한 API를 제공한다.

### 3. csrf 비활성화 하기
  - 설정 클래스에서 `configure(HttpSecurity)` 메소드를 오버라이드 하고
  -  파라미터로 넘어온 `HttpSecurity` 에서 `csrf().disable()` 메소드를 호출해 준다.
  - [ ] CSRF란?
  - [ ] https://okky.kr/article/396206
