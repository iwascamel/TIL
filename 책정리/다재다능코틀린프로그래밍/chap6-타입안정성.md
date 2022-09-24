# chap 6 - 타입 안정성

## 1. 도입

* 코틀린의 Design By Contract 접근방식으로 개발자는 함수나 메서드가 null을 받거나 return할 수 있는 지 명확하게 표현할 수 있으며, 그 시점도 알 수 있다.
* 코틀린은 null 체크에 대해서, 컴파일 타임에만 이루어지고 byte code에는 아무것도 추가되지 않는다.
* Any
    * Java의 Object에 대응되는 클래스이다.
    * Nothing은 함수가 아무것도 return하지 않을 때 return하는 클래스이다.
    * Any는 확장함수를 통해서 특별한 메서드를 제공한다. 즉, Object보다 많은 기능을 제공한다.

## 2. Nothing

* [Chap6-2-Nothing](./codes/chap6/Chap6-2-Nothing.kt)
* Nothing은 void보다 강력하다.
* Nothing 클래스는 인스턴스가 없고 값이나 결과가 영원히 존재하지 않을 것이라는 것을 나타낸다.
* 예외는 Nothing 타입을 대표한다.

## 3. null

* Java Optional의 단점
    1. Optional을 추가로 사용해야 한다.
    2. 객체가 없다면 오버헤드가 발생한다.
    3. Optional이 아니고, null을 return 하더라도 java컴파일러는 별다른 경고를 해주지 않는다.
* effective java의 collection return null 관련 조언
    * runtime에, collection을 return하는 함수가 return 할 게 없다면, null을 return 하지말고 빈 컬렉션을 return해야 한다.
    * null을 return한다면 null로 인한 runtime 에러가 발생할 수 있고, 이를 피하려면 반드시 null 체크를 해줘야 되기 때문이다.
* 코틀린 코드를 작성할 때, Java와 상호운용할 목적이 아니라면 null이나 nullable 타입은 절대 작성하지 않는 게 좋다.
* String? -> String
    * 바이트코드에서는 String?이 String으로 변환되기 때문에 오버헤드가 존재하지 않는다.
* !!
    * !!를 사용하지 마라.
        * `name!!.reversed().toUpperCase()` 와 같은 코드가 있을 때, 만약 다음 step에서 null이 터지면 그냥 앱이 터져버린다.
    * 그냥 존재하지도 않는다고 생각해라.
* ?. , ?: 보다 when
    * safe call이나 elvis 연산자는 값을 추출할 때 사용하고, null 가능 참조에 대해서 처리할 때는 when을 사용해라.

## 4. type casting

* 확장성의 측면에서 봤을 때, type 체크는 최소한으로 해야한다.
    * 임의의 type을 체크하는 행위는 새로운 type이 추가됐을 때 코드를 부서지기 쉽게 만들고, 개방 폐쇄 원칙에도 어긋난다.
* is
    * java의 instanceof와 같은 연산자이다.
* smart casting
    * 선행 코드 라인에서 체크가 됐으면, 아래에서는 type casting을 하지 않아도 된다.
* [kotlin equals구현 & is 연산자 활용](./codes/chap6/Chap6-4-typeCasting.kt)
    * Any타입이 String 타입으로 확인이 됐다면, 이후부터는 String 타입인 것처럼 활용이 가능하다.
* 명시적 타입 캐스팅은 컴파일러가 타입을 결정할 수 없어서 스마트 캐스팅을 하지 못했을 경우에만 사용해라.
    * 만약 객체의 type이 다를 경우, runtime error가 발생할 수 있다.
* 원칙: smart cast
    * 가능한 smart cast를 사용해라.
    * smart cast가 불가능하다면, 그때서야 명시적 cast를 사용해라.
    * application이 불타는 것을 보고 싶지 않다면(ㅋㅋ), 안전한 캐스트 연산자를 사용해라(?을 사용하라는 말이다.).

## 5. 제네릭
