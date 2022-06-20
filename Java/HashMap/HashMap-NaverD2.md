# Naver D2 Hashmap

## 1. 도입

과거엔 HashTable을 사용했지만, 현재는 HashTable의 개량 버전으로 HashMap을 주로 사용한다.

`hashmap`의 bucket은 각 객체가 반환하는 `hashCode()`를 기반으로 하고 있다. `hashCode()`는 int형을 기반으로 하기 때문에 다음과 같은 한계가 있다.

1. 2^32까지 밖에 표현이 안된다.
2. 2^32 bucket을 전부 들고 있을 순 없다.

그렇기 때문에 완전한 O(1)을 보장해주지는 못한다.

```other
int index = X.hashCode() % M;
```

* M
  * 실제 해시의 표현범위 N보다 작은 M값

충돌시, 데이터 저장 방법으로 `Open Addressing`과 `Chaning`을 사용할 수 있다.

> * 이 때 Open Addressing의 방법 중에는 Linear Probing을 주로 사용하는 것 같다.

## 2. Open Addressing의 장점

Open Addressing의 장점은 연속된 공간에 데이터를 저장하기 때문에 Chaning에 비해 *캐시 효율이 높다* 라는 장점이 있다.하지만 배열이 커질수록 Cache miss의 빈도가 높아지기 때문에 장점이 사라진다.

## 3. Java에서의 방법

*Java에서는 chaing을 사용한다.*
왜냐하면 open addressing - linear probing의 경우 삭제가 효율적이기 어려운데, `remove()` 메서드가 빈번히 호출될 수 있기 때문이다.

거기다가 키-쌍 개수가 일정 수를 넘어가면 linear probing은 chaning보다 느리다. 밀도가 높아질 수록 worst case의 빈도가 높아지기 때문이다.

데이터가 8이상이면 RedBlackTree로 변경하고, 데이터가 6이하면 LinkedList로 변경한다.
그 이유는 트리가 LinkedList보다 메모리 사용량이 많고, 적은 데이터에서는 수행 시간 차이가 거의 차이 나지 않기 때문이다.

데이터를 2차이로 둔 이유는 1차이로 `add()`와 `remove()`가 반복되면 쓸데없이 자료구조의 변경이 일어날 것을 대비해서이다.

## 4. 해시 버킷의 동적 확장

해시 버킷의 개수가 작다면 메모리를 아낄 수 있지만, 데이터가 많아질 경우 충돌이 발생해 비효율적인 상황이 발생할 수 있다.
그래서 키-값쌍이 일정 수준이상이 되면 버킷의 용량을 2배로 늘린다.
해시 버킷의 기본 값은 16이고, 임계점에 이를때마다 해시 버킷의 개수를 2배씩 늘린다.

## 5. 보조 해시 함수

```other
index = X.hashCode() % M
```

일 때 M이 소수일 때 가장 index가 균등하게 생성될 수 있다.
그런데, M은 소수가 아니므로 보조해시 함수를 사용해서 index가 균등하게 배포될 수 있게 해야한다.

<hr/>

* 출처
  * [Java HashMap은 어떻게 동작하는가?](https://d2.naver.com/helloworld/831311)

