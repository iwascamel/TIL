# chap4. 외부 반복과 argument 매칭

## 1. Range

* [Chap4-1](codes/chap45/Chap4-1.kt)
* range 자료형
    * IntRange, CharRange등 기본형 + Range 자료형이 존재한다.
* for loop 안의 i는 val이다.
* downTo
    * `5.downTo(1)` 이렇게도 사용할 수 있다.
    * `5 downTo 1` 이게 더 직관적이긴 하다.
* until은 마지막 값을 포함하지 않는다.
* step은 값의 증가값을 나타낸다.

## 2. Array

* [Chap4-2](codes/chap45/Chap4-2.kt)
* arrayOf()
    * 배열을 만들 때 import없이 사용할 수 있다.
    * withIndex()
        * (index,value) 구조분해로 받는다.
    * indicies()
        * index만 받는다.

## 3. when

* [Chap4-3](./codes/chap45/Chap4-3.kt)
* when이 명령문으로 사용될 때는 else가 없어도 상관없다.

# chap5. 컬렉션 사용하기

## 1. 도입

* 프로그램이 간단한 single thread라면 mutable collection interface 사용, 복잡한 비동기 프로그래밍이라면 immutable collection을 사용하라.
* 배열은 낮은 수준의 최적화가 필요할 때만 사용하고, 그 외에는 List와 같은 다른 자료구조를 사용하라.
* `get()` 대신 `[]`를 사용하라.
    * 인덱스 연산자를 사용하면 내부적으로 `get()`메서드를 사용하게 된다.
    * 인덱스 연산자를 사용하는 편이 `get()`보다 노이즈가 적고 편리하다.

## 2. 코드

* [Chap5-컬렉션 사용하기](./codes/chap45/Chap5.kt)
* map, set, list
    * listOf, setOf, mapOf 등을 사용하면 immutable 타입이 반환된다.
* immutable은 쓰기가 불가능하다.
    * 값을 추가 및 삭제하려면 +, - 로 가능하다.
    * 새로운 mutableMap을 반환한다.