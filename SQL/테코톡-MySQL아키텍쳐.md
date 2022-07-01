- [우기의 MySQL 아키텍쳐](#우기의-mysql-아키텍쳐)
  - [1. 아키텍쳐](#1-아키텍쳐)
  - [2. 쿼리 실행 과정](#2-쿼리-실행-과정)

# 우기의 MySQL 아키텍쳐

## 1. 아키텍쳐
<img width="872" alt="image" src="https://user-images.githubusercontent.com/51740388/174826438-404833f6-4dbc-4ddd-bec1-c51c3db51876.png">

* `접속 Client`
  * MySQL은 대부분의 프로그래밍 언어에 대해서 접속 API를 제공한다.
* `MySQL Engine`
  * 두뇌에 해당한다.
  * Client접속과 SQL 요청을 처리한다.
    * 이 중 Optimizer는 최적화 된 실행 계획을 짜는 중요한 역할을 담당한다.
    * 해당 Optimizer 때문에 MySQL Engine이 두뇌에 비유된다.
* `Storage Engine`
  * Optimizer가 작성한 계획에 따라서 Storage Engine을 적절히 호출해서 쿼리를 실행한다.
    * MySQL Engine이 Storge Engine을 호출할 때 사용하는 API를 `Handler API` 라고 한다.
* `File System`
  * 파일을 저장

## 2. 쿼리 실행 과정

<img width="474" alt="image" src="https://user-images.githubusercontent.com/51740388/174827597-89bb46e3-40a2-46ef-9261-00ed3181809f.png">

1. 가장 먼저 Query Cache를 만난다.
   * 만약 caching하고 있는 테이블이 변경된다면 해당 캐시를 삭제해야 한다.
     * 이 때마다 query cache에 접근하는 `Thread` 에 Lock이 걸린다.
       * 이는 심각한 성능 저하를 유발한다. 그래서 MySQL 8부터 삭제됐다.
  
2. QueryParser
    * 기본적인 SQL 문장 오류를 체크한다.
      * 해당 SQL을 의미있는 단위로 쪼개서 트리로 만든다.
        * 해당 트리를 `Parse Tree` 라고 한다.

<img width="400" alt="image" src="https://user-images.githubusercontent.com/51740388/174828285-d70224cb-d0e9-4a45-8a24-2478d60f0a74.png">

3. Preprocessor(전처리기)
   * `Parse Tree`를 기반으로 값을 검사한다.

4. Optimizer
   * 최적화를 한다.
   * 규칙 기반 최적화
     * 우선순위
   * 비용 기반 최적화
     * 각 Query 비용에 따라 실행하는 방법

5. Query Execution Engine
   * Optimizer가 마련한 실행 계획에 따라 Storage Engine을 적절히 호출해서 Query를 실행한다.

6. Storeage Engine
   * 해당 storage engine은 plugin형태로 존재하기 때문에 사용자가 원하는 대로 선택할 수 있다.
     * 해당 engine은 innoDB, MyISAM등 다양하게 존재한다.

<hr/>

* [우기의 MySQL 아키텍처](https://www.youtube.com/watch?v=vQFGBZemJLQ&ab_channel=%EC%9A%B0%EC%95%84%ED%95%9CTech)
  * 4분까지의 기록