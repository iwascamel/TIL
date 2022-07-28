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

### 2-1) 변수

* 변수 저장 공간
  * Primitive Type
    * Stack memory
  * Reference Type
    * Heap Memory

* static 키워드
  * O
    * 클래스 변수
  * X
    * 인스턴스 변수

### 2-2) 초기화 방법

초기화 방법은 아래와 같이 3가지 방법이 존재한다.
1. 명시적 초기화
2. 생성자
3. 초기화 블럭

* 명시적 초기화
```java
class Car {
	int door = 4;                     // 기본형 변수의 초기화
	Engine engine = new Engine();     // 참조형 변수의 초기화
}
```

* 초기화 블럭
  * 클래스 초기화 블럭
    * 클래스가 처음 메모리에 로딩될 때 한 번만 수행된다.
  * 인스턴스 초기화 블럭
    * 생성자와 같이 인스턴스가 생성될 때 수행된다.
    * 생성자보다 먼저 수행된다.

* 초기화 블럭 내에서는 method와 같이 조건문, 반복문, 예외 처리 구문등을 자유롭게 사용 가능하다.
  * 초기화 작업이 복잡해서 명시적 초기화만으로 부족한 경우, 해당 초기화 블록을 사용한다.

```java
clasas InitBlock{
	// 클래스 초기화 블럭
	static {
	}

	// 인스턴스 초기화 블럭
	{
	}
}
```

### 2-3) 초기화 블록의 사용 예시

> * [생성자에서 코드 중복이 일어나는 상황](./chap2_codes/DataType1.java)
> * [위의 코드의 중복을 초기화 블럭으로 해결](./chap2_codes/DataType2.java)

```java
public Car(){
    count++;
    index = count;
    this.color = "white";
}

public Car(String color) {
    count++;
    this.index = count;
    this.color = color;
}
```

* 위처럼 생성자마다 중복이 있던 코드를 아래와 같이 초기화 블록을 통해 중복을 줄일 수 있다.

```java
{
    count++;
}
```

### 2-4) 초기화 블록 생성 순서

> * [생성 순서](./chap2_codes/BlockTest.java)

* class 초기화 블럭 -> 인스턴스 블럭 -> 생성자 순으로 실행된다.
  * class 초기화 블럭의 경우 메모리에 처음 로딩될 때 딱 한 번만 초기화 실행이 이뤄지는 것을 볼 수 있다.

* 위 예제의 경우
```  
static
instance
constructor
instance
constructor
```
* 가 출력

### 2-5) 초기화 블록의 사용

> * [생성 예제](./chap2_codes/StaticBlockTest.java)

* 위와 같이 복잡한 code 초기화 작업 시 클래스 초기화 작업을 해주면 좋다.

## 3. 변수 scope, life cycle

* scope?
  * 변수에 접근할 수 있는 유효 범위/영역을 지칭
* static 영역에서는 instance를 참조하지 못한다.

| 변수           | 선언 위치 | 생성 시기 (메모리 할당 시기) | scope       |
| -------------- | --------- | ---------------------------- | ----------- |
| class          | static    | class가 memory에 올라갈 때   | 클래스 전역 |
| instance       | stack     | new 연산자를 통해 생성될 때  |             |
| local variable | stack     |                              |

## 4. type casting

### 4-1) 조건

* Primitive type들의 type casting은 모두 서로 변환 가능하다.
  * 단, 데이터의 손실이 발생한다.
* Reference type은 상속관계여야만 서로 변환이 가능하다.

### 4-2) reference type 조건

> * [DownCasting 예제 및 활용법](./chap2_codes/UpDownCasting.java)

* 부모 클래스에는 명시적인 type casting 없이 자식 인스턴스를 넣을 수 있다.
  * 이는 부모보다 자식 인스턴스의 영역(크기)이 더 크므로 가능하다.
    * 즉, 부모에서 어떤 멤버변수나 메서드를 참조해도 자식 인스턴스내에 선언돼있기 때문에 참조가 가능하다.

<img width="300" alt="image" src="https://user-images.githubusercontent.com/51740388/181522055-b061916d-bdb9-4662-b799-017332c24d47.png">

* 하지만 반대의 경우 자식 클래스의 범주가 더 클 경우 부모 인스턴스로는 대체가 되지 않는다.
  * 다운 캐스팅은 Paremeter에 부모type으로 argument를 받을 때, 해당 instance를 다시 자식으로 돌릴 때 주로 사용한다.

* Up
  * 자식 to 부모 (올라간다)
* Down
  * 부모 to 자식 (내려간다)