# Caching Strategy 101

## 1. Cache Hit AND Miss

* Cache hit이 일어날 경우 굳이 DB까지 갔다와서 데이터를 가져올 필요 없다.
* miss가 날 경우, 이 때 여러 전략을 선택할 수 있다.

> 캐시 전략은 [해당 글](Caching-101.md)을 참조하자.

## 2. Cache Strategy

### 2-1) Cache Aside Pattern

* hit이 날 경우 cache로부터 데이터를 읽어온다.
* miss가 날 경우 db로부터 데이터를 읽어오고, 후에 cache에 데이터를 write한다.
  * 해당 패턴은 `read through cache` 라고도 불린다.

* Cache Aside techniques are primarily used for Read Heavy Workloads where the overall system can withstand cache failures and downtimes. Using Lazy load caching strategy improves the overall write latency for Database Create and Update operations and is primarily used in application design with frequent write operations.
  * 해당 패턴은 `Read Heavy Workloads` 에 적합하다.
  
* 첫 사용자는 성능상 disadvantage를 갖는다.

### 2-2)Write Through Pattern

* data를 캐시에 먼저 저장하고, db에 저장하는 방식이다.
* 캐시는 항상 최신의 정보를 갖고 있고, DB와 동기화 된다는 장점은 있지만 두가지 단점이 존재한다.
  1. 항상 두가지 스텝을 걸쳐야 하기 때문에 추가 쓰기 시간이 발생한다.
  2. 재사용 되지 않는 모든 데이터를 다 cache에 저장하기 때문에 리소스 낭비가 발생한다.

* 그래서 cache에 얼마간 데이터를 저장하겠다는 `TTL`을 설정해주는 것이 좋다.

<hr/>

* [참조 블로그1 - 종원](https://loosie.tistory.com/800#1._Look-Aside_%EC%9D%BD%EA%B8%B0_%EC%A0%84%EB%9E%B5_(Lazy_Loading))
* [Caching Strategy 101](https://medium.com/dev-genius/caching-strategy-101-3bc974d2a6cd)
* date
  * 22.07.14