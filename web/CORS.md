# 얄팍한 코딩사전 CORS

## 1. CORS란?

### 1-1) CORS에러 발생 상황

* 한 사이트에서 주소가 다른 서버로 요청을 보넀을 때 자주 접하게 되는 오류이다.
  * 프론트에서 크롬이나 사파리같은 브라우저에서 일어나는 일이다.
* 예시
  * 사용자 서식을 받아오려고 네이버 지도 API에 AJAX요청을 보냈는데, CORS 에러로 요청이 보내지지 않았다.
* 이때, CORS로 제어를 가하는 것은 **브라우저**쪽이다.
  * 사용자를 못 믿는 것이 아니라, 사용자가 방문하는 해당 사이트를 믿지 못한다.

### 1-2) CORS의 존재 이유

* 크롬, 나의 브라우저에는 쿠키로 사용자 정보를 갖고 있는 파일이 존재한다.
  * A사이트에 사용자가 접속하고 있다고 해보자. A사이트 내에서 악의적인 사용자는 다른 사용자가 B사이트에 접속하게 유도해서 A사이트의 쿠키를 B사이트로 전송하게 유도할 수 있다.
  * 그렇기 때문에 `SOP(Same Origin Policy)` 로 해당 행위를 방지한다.
    * 한국말로는 동일출처 정책이다.
  * `CORS(Cross Origin Resource Sharing)`는 SOP를 풀어주는 역할을 한다.
    * 에러 로그에 CORS 어쩌고가 뜨는 것은, SOP 때문에 막혀있으니 해당 에러를 해결하려면 CORS를 통해 SOP를 풀어라라는 것이다.

### 1-3) CORS에 대한 자세한 설명

> CORS = 말 그대로 다른 출처간에 resource를 공유할 수 있도록 하는 것을 의미한다.

* 출처란?
  * 보내고 받는 각각의 위치
    * 즉, `web site` 와 `Api location` 을 의미한다.
* resource란?
  * 보내고 받아지는 `data`를 의미한다.
* 즉, 서로 다른 출처끼리 정보요청과 반환이 가능하도록 하는 게 `CORS`이다.
* 원래는 안됐는데, 웹 생태계가 다양해지면서 data를 자유롭게 주고받을 필요성이 생겼다.
* CORS는 일정 조건을 만족시키면 서로 다른 도메인간에 자원 공유를 하게 만드는 것이다.

## 2. CORS 설정 방법

### 2-1) CORS 동작방법

* 설정하는 법은 간단하다. backend에서 허락할 다른 출처들을 명시해주면 된다.
* 출처에 대한 추가 설명
  * 내  web site에서 네이버 지도 API로 요청을 보내면, 다른 `출처` 로의 요청이니까 `cross-origin 요청`이다.
* 브라우저는 이처럼 다른 출처끼리의 요청이 보내질 때는 header에 `Origin`이라는 헤더를 추가한다.
  * `Origin`의 헤더에는 요청하는 쪽의 scheme, Domain, Port 등의 정보가 담긴다.
    * `scheme`
      * 요청할 자원에 접근할 방법
        * http, ftp, telent 등 (프로토콜)
* 요청을 받은 네이버 지도 API는 지정된 `Access-Control-Allow-Origin` 정보를 실어서 다시 web site로 보낸다.
  * 만약 내 web site가 등록돼 있었다면, 내 web site가 해당 data에 들어가 있을 것이다.
* 내 브라우저(chrome)이 `Origin`과 `Access-Control-Allow-Origin`을 비교해서, `Origin`에 보낸 출처값과 같다면 해당 요청을 허용해준다.

### 2-2) token등 사용자 식별 정보가 담긴 요청

* 보다 엄격하다.
* 보내는 쪽에서는 요청의 option에 `credential` 항목을 `true`로 세팅해야 한다.
* 받는 쪽에서는 아무 출처나 다 된다는 `wildcard` 로 설정하면 안된다.
  * 보내는 쪽의 출처, 웹페이지 주소를 정확히 명시해야 한다.
    * `Access-Control-Allow-Credential` 항목을 `true`로 세팅해야 한다.
* 위의 방법은 `Simple Request`라고 해서 `GET` `POST` 등의 일정 조건 요청들에 사용된다.
  * 서버의 data에 영향을 줄 수 있는 `PUT` `DELETE`등은 `Preflight`이라는 요청을 먼저 보내서 해당 요청이 안전한지 확인한다.
  * 즉 `Preflight` 요청들은 요청은 보내는 것 자체도 허락을 받아야 한다.

## 출처

* [얄팍한 코딩사전](https://www.youtube.com/watch?v=bW31xiNB8Nc&t=533s&ab_channel=%EC%96%84%ED%8C%8D%ED%95%9C%EC%BD%94%EB%94%A9%EC%82%AC%EC%A0%84)






