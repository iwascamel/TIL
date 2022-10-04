# chapter7. 객체와 클래스

## 1. 객체와 싱글톤

* [chap7-1](./codes/chap7/chap7-1-annonymous.kt)
    * `object`나 lambda를 통해 익명클래스를 생성할 수 있다.
* 탑레벨, 싱글톤
    * 사용할 함수들이 하이레벨이거나, 일반적이거나, 넓게 사용될 예정이라면 패키지 안에 직접 넣어서 탑레벨 함수로 사용하는 게 좋다.
    * 반대로 함수들이 연관돼 있다면, 싱글톤을 사용하는 게 좋다.
* 코틀린은 각종 boiler plate코드 생성을 IDE에서 컴파일러로 이동시켰다.
* 클래스의 멤버가 public이면 생성자 역시 public이다.
* 바이트코드 생성방법
    * `kotlinc-jvm UseCar.kt`
    * `javap -c UseCarKt.class`

## 2. 클래스

### 2-1) 클래스 속성

* [chap7-2](./codes/chap7/chap7-2-class.kt)
    * 속성과 파라미터 이름은 다른 이름을 사용하도록 하자.
    * `var color = theColor` -> O
    * `var color = color` -> x
* 코틀린 개발자는 필드를 만들 수 없다.

### 2-2) 접근 제어자

* internal
    * 같은 모듈내에서 접근 가능
    * 모듈이란?
    * 함께 컴파일된 모든 소스코드
* getter
    * 속성의 접근 권한과 동일하다.
  
### 2-3) 초기화(init)

* 클래스에서 내부에 선언된 속성을 사용하기 위해서는 init 블록을 가장 아래에 위치시켜야한다.
* 아래와 같은 순서로 코드를 배치하라.
    * attributes
    * init
    * constructor
    * method
* [chap7-2-3-init](./codes/chap7/chap7-2-3-init.kt)
* 그 이유는 init 블록 내에서 변수를 사용하려면 init 블록 위에 있는 변수들이 필요하기 때문이다.
* init블록은 가급적 사용하지 말라.
    * 가급적 init블록은 1개만 만들고, 가능하다면 만들지 마라.
    * 생성자에서 최대한 아무런 작업도 하지 않는 것이 안정성과 성능면에서 모두 좋다.

### 2-4) inline class

* 컴파일 시간에는 클래스의 장점을 취할 수 있고, 런타임에는 primitive type으로 취급된다.
    * 즉, byte code로 변환됐을 때 primitive type의 장점을 취할 수 있는 것이다.
* inline class는 final이 돼야 하고, 다른 클래스에 의해 확장될 수 없다.

## 3. companion object

* [chap7-3-companionObject](./codes/chap7/chap7-3-companionObject.kt)
* 컴패니언 객체는 클래스 안에 정의한 싱글톤이다.
* 컴패니언 객체는 클래스의 팩토리로 사용될 수 있다.
* 컴패니언을 팩토리로 사용하기 위해서는 class에 private constructor를 만들어줘야 한다.
* [chap7-3-factory](./codes/chap7/chap7-3-factory.kt)
    * 위처럼 companion object를 factory로 활용할 수 있다.
* companion의 method가 class의 static method가 된다고 생각하면 안된다.
  
## 4. data class

* 데이터 클래스는 알아서 `equals()`, `hashcode()`, `toString()` 등을 생성해주며, shallow copy method인 `copy()` 메서드도 자동으로 생성해준다.
    * shallow copy는 참조복사(얕은복사)를 의미한다.
    * 또, componentN(구조분해) 역시 제공해준다.
* 구조분해
    * 구조분해는 편리하나, data property의 순서대로 구조분해를 제공한다는 점에서 주의할 점이 존재한다.
    * 만약 data property의 순서가 바뀐다면, 구조분해의 순서 역시 바뀌기 때문이다.