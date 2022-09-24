# chap 6 - 타입 안정성

## 1. 도입

* 코틀린의 Design By Contract 접근방식으로 개발자는 함수나 메서드가 null을 받거나 return할 수 있는 지 명확하게 표현할 수 있으며, 그 시점도 알 수 있다.
* 코틀린은 null 체크에 대해서, 컴파일 타임에만 이루어지고 byte code에는 아무것도 추가되지 않는다.
* Any
    * Java의 Object에 대응되는 클래스이다.
    * Nothing은 함수가 아무것도 return하지 않을 때 return하는 클래스이다.
    * Any는 확장함수를 통해서 특별한 메서드를 제공한다. 즉, Object보다 많은 기능을 제공한다.

## 2. Nothing

* []
* Nothing은 void보다 강력하다.
* Nothing 클래스는 인스턴스가 없고 값이나 결과가 영원히 존재하지 않을 것이라는 것을 나타낸다.
* 예외는 Nothing 타입을 대표한다.