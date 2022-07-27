# 자바 데이터 타입, 변수 그리고 배열

## 1. Primitive type(기본형)

### 1-1) 기본 구조 설명

* 총 8가지의 기본형이 존재
* 기본형에 null을 넣고 싶다면 Wrapper class 활용한다.
* 기본형 타입은 jvm memory영역 중 `stack`에 저장된다.
* compile time에 type에 따른 memory 체크가 일어난다. 만약 해당 범위를 벗어나면 compile error가 발생한다.

### 1-2) 8가지 타입

| 구분   | type         | memory size    | default value | range                   |
| ------ | ------------ | -------------- | ------------- | ----------------------- |
| 논리형 | boolean      | 1 byte         | false         | true, false             |
| 정수형 | byte         | 1byte          | 0             | -128~127                |
|        | short        | 2byte          | 0             | -3만~3만(32767)         |
|        | int(기본)    | 4byte          | 0             | -21억~21억(10자리)      |
|        | long         | 8byte          | 0             | 9~ 로 시작하는 19자리수 |
| 실수형 | float        | 4byte          | 0.0F          | 3.4*10^38               |
|        | double(기본) | 8byte          | 0.0           | 1.7*10^308              |
| 문자형 | char         | 2byte(unicode) | \u0000        | 0~65,5                  |

## 2. 변수 선언 및 초기화

* Primitive Type
  * Stack memory
* Reference Type
  * Heap Memory