# 섹션4 - 코틀린의 OOP

## 1. class

* [class, 생성자](../codes/section4/Sec4_1_2_constructorOverloading.kt)

### 1-1) class, property

* property란
    * field + getter + setter

* kotlin에서는 val, var등을 통해 field만 만들면 getter, setter를 자동으로 생성해준다.
    * 때문에 주 생성자에 들어가는 parameter들을 property라고 부른다.
* kotlin에서는 생성자에서 property를 만들 수 있다.
    * java코드를 가져오더라도 `person.getName()`이 아니라, `person.name`만 치더라도 가져와진다.

#### . field

* getName() 과 같이 사용하지 않더라도, `person.name` 과 같이 바로바로 사용 가능하다.

### 1-2) 생성자와 init

#### 검증로직

```kotlin
class Person (val name:String, var age:Int)
```

* 위와 같이만 짜면, `if(age<=0) throw error` 와 같이 error를 날릴 수 없다.
* 그래서 init {} 블록이 존재한다.
    * init 블록은 생성자가 호출되는 시점에 호출되는 블록이다.
    * 값을 적절히 만들어주거나, validation 로직에 넣는 용도로 사용된다.

#### 생성자 overloading

```kotlin
constructor(name:String): this(name,1)
```

* 기본 생성자가 존재할 때, 위와 같이 constructor와 this를 이용해서 호출해준다.
* 이 때,

```kotlin
class Person(val name:String, var age: Int)
```

* 위 코드의 생성자는 주 생성자라고 한다.
    * 주 생성자는 반드시 존재해야 한다.
    * 만약 멤버변수가 하나도 없는 경우엔 kotlin이 알아서 생성해주기 때문에 굳이 생성자를 명시해주지 않아도 된다.

* 코드 안에 있는 constructor 생성자는 부 생성자라고 하고, 없을 수도 있다.
    * 부 생성자는 최종적으로 주 생성자를 this로 호출해야 한다.
    * 부 생성자는 body를 가질 수 있다.

* 만약 두번째 부 생성자를 호출한다고 해보자.
    * [코드참조](../codes/section4/Sec4_1_2_constructorOverloading.kt)

```
초기 생성자
첫번째 부 생성자
두번째 부 생성자
```

* 그러면 init -> 첫번째 부 생성자 -> 두번째 부 생성자가 호출된다.
    * 즉, 역순으로 호출된다.
* 그런데 kotlin에서는 부생성자보다는 default parameter를 권장한다.

```kotlin
class Person(
    val person: String = "임얼쑤",
    var age: Int = 1
)
```

* 만약 converting과 같이 어떤 객체를 다른 객체로 바꾸는 경우에는 부 생성자를 사용할 수는 있지만, 그보다는 정적 팩토리 메서드가 추천된다.
    * 사실상 부 생성자는 거의 사용할 일이 없다.

### 1-3) custom getter, setter

* [getter를 property로 반환하는 방법](../codes/section4/Sec4_1_3_getterSetting.kt)
    * 객체의 속성이라면 custom getter
        * 그렇지 않다면 함수를 사용하자.
        * ex) isAdult => 해당 사람이 성인인가라는 속성을 확인하는 것처럼 보인다.
            * 이 때는 custom getter가 활용되는 프로퍼티처럼 보이게 하는 게 좋다.

* [custom getter 만들기](../codes/section4/Sec4_1_3_customGetter.kt)
    * `class Person(val name:String)` 으로 설정하면 getter를 자동으로 만들어주므로, val을 선언해주지 말자.
    * field 사용 이유
        * 만약 get() = name.uppercase()를 사용하게 되면, name을 부르면 get()을 호출하고, get()은 다시 name(name에 대한 getter를 호출)을 호출하므로 무한루프에 빠진다.
        * 그래서 자기 자신을 가르키는 field라는 예약어가 생겼다.
            * field를 지칭하면 진짜 name을 가르킨다.

### 1-4) backing field

* 1-3)의 field를 자기 자신을 가르키는 보이지 않는 field라고 해서 backing field라고 부른다.
    * 그러나 custom getter에서 backing field를 사용하는 일은 드물었다.
    * 왜냐하면 진짜 property에 대해서 getter를 만들어줄 때 사용한다.
    * [함수를 만들어서 return 하는 방법 & setter 설정](../codes/section4/Sec4_1_4_backingField.kt)

* setter에서 field는 유효하게 사용될 수 있으나, setter 자체가 잘 사용되지 않으니 backing field자체가 잘 사용되지 않는다.

## 2. 상속

### 2-1) 추상 클래스

* [abstract](../codes/section4/Sec4_2_1_abstract.kt)

### 2-2) 인터페이스

* [interface](../codes/section4/Sec4_2_2_interface.kt)

### 2-3) 클래스를 상속할 때 주의할 점

* [주의점](../codes/section4/Sec4_2_3_waringPoint.kt)
    * 상위 클래스에서 하위 클래스가 override하고 있는 property를 생성자 블록이나 init블록을 쓰게 되면 이상한 값(쓰레기값)이 나올 수 있다.
    * 상위 클래스를 설계할 때는 생성자 또는 초기화 블록에 사용되는 property에는 open을 반드시 피해야 한다.

* 상속 관련 키워드 4가지
    * final
        * override를 막는다.
        * default값
    * open
        * override를 열어준다.
    * abstarct
        * 반드시 override 해야한다.
    * override
        * override를 하고 있다.


## 3. 코틀린에서 접근제어를 다루는 방법

### 3-1) 자바와 코틀린의 가시성 제어

#### java

* public
    * 모든 곳
* protected
    * 같은 패키지 + 하위 클래스
* default
    * 같은 패키지
* private
    * 같은 클래스

#### kotlin

* public
    * 모든 곳
* protected
    * 같은 패키지 x
        * 코틀린에서는 package를 namespace를 관리하기 위한 용도로만 사용한다.
        * 즉, 가시성 제어에는 사용되지 않는다.
            * 가시성 제어 : [같은 패키지안에 있으니까 너네는 소통할 수 있어]
    * 선언된 클래스 + 하위 클래스
* internal
    * 같은 모듈에서만 접근 가능
        * 모듈
            * 한 번에 컴파일 되는 kotlin 코드
            * ex) gradle -> gradle source set
                * 즉, gradle에서 만든 프로젝트
    * 상위 모듈과 하위 모듈이 있을 때, 하위 모듈에 있는 internal이 붙은 클래스나 함수를 상위 모듈에서 가져오지 못한다.
* private
    * 선언된 클래스에서만 가능

* 요약하면 public, private은 똑같다.
    * protected에서는 package 제거
    * default는 빠지고 internal
        * internal에서는 모듈을 제어하는 기능이 생겼다.

* java의 기본 접근 지시어
    * default
* kotlin의 기본 접근 지시어
    * public

* kotlin에서는 .kt파일에 변수, 함수, 클래스를 여러 개를 만들 수 있다.

### 3-2) 코틀린 파일의 접근 제어

* public
* protected
    * 파일에는 사용할 수 없다.
* internal
    * 같은 모듈에서만 접근 가능
* private
    * 같은 파일내에서만 접근 가능

### 3-3) 다양한 구성요소의 접근 제어

* 클래스, 생성자, 프로퍼티
* 클래스 안의 멤버
    * 클래스의 범위와 똑같다.
* 생성자
    * 생성자의 접근 지시어를 붙이려면, constructor를 써주어야 한다.
    * [range](../codes/section4/Sec4_3_3_range.kt)

#### 유틸성 코드

* abstract class + private constructor

```java
public abstract class StringUtils{
    private StringUtils(){}
    public boolean isDirectoryPath(String path){
        return path.endsWith("/");
    }
}
```

* [kotlin에서 utils](../codes/section4/Sec4_3_3_utils.kt)
* [접근 지시어 설정](../codes/section4/Sec4_3_3_rangeV2.kt)

### 3-4) java와 kotlin을 함께 사용할 경우 주의점

* internal은 byte code상 public이 된다.
    * 즉, java코드에서는 kotlin 모듈의 internal코드를 가져올 수 있다.
* java는 같은 패키지의 kotlin protected 멤버에 접근할 수 있다.

## 4. kotlin에서 object키워드를 다루는 방법

### 4-1) static 함수와 변수

* static
    * 클래스가 인스턴스화 될 때 새로운 값으로 복제되는 것이 아니라, 정적인 영역에서 값이 공유된다.
* companion object
    * 클래스와 동행하는 유일한 오브젝트

* companion object는 하나의 객체로 간주된다.
    * 때문에 이름을 붙일 수도 있고, 인터페이스를 구현할 수도 있다.
* companion object에 유틸성 함수들을 넣어도 되지만, 최상단 파일을 활용하는 것이 추천된다.
* java에서 kotlin companion object를 사용하려면 @JvmStatic을 붙여주어야 한다.

### 4-2) 싱글톤

* [object Singleton](../codes/section4/Sec4_4_2_singleton.kt)
    * object만 붙여주면 된다.
    * 그러나 object를 붙여서 싱글톤을 사용할 일은 거의 없다.

### 4-3) 익명 클래스

* [anonymous](../codes/section4/Sec4_4_3_anonymous.kt)

## 5. 중첩클래스

### 5-1) 중첩 클래스의 종류

#### java

* static을 사용하는 중첩클래스
* static을 사용하지 않는 중첩클래스
    * inner class
    * local class
    * anonymous class

<img width="507" alt="image" src="https://user-images.githubusercontent.com/51740388/185149228-fe4f7d27-8386-4d44-9c9d-ced092031820.png">

* class 내부 non-static class는 외부 클래스에 대한 직접 참조를 갖고 있고, static class는 외부 클래스에 대한 직접 참조가 없다.
    * 이펙티브 자바 item 24, 86
        * 내부 클래스는 숨겨진 외부 클래스 정보를 갖고 있어, 참조를 해지 못하는 경우 메모리 누수가 생길 수 있고 디버깅이 어렵다
        * 내부 클래스의 직렬화 형태가 명확하게 정의돼 있지 않아 직렬화에 있어 제한이 있다.
        * 그래서 내부 클래스를 사용할 때는 static 키워드를 사용하라.
            * 코틀린은 해당 가이드를 충실히 따르고있다.

### 5-2) 코틀린의 중첩 클래스와 내부 클래스

* [중첩클래스와 내부클래스](../codes/section4/Sec4_5_2_anonymousClass.kt)

## 6. 코틀린에서 다양한 클래스를 다루는 방법

### 6-1) Data Class

* dto, data(field), 생성자와 getter, equals and hashCode, toString 등

* [data class](../codes/section4/Sec4_6_1_dataClass.kt)
    * named argument까지 활용하면 builder패턴까지 활용하는 이점을 누린다.

### 6-2) Enum Class

* java
    * 추가적인 클래스를 상속받을 수 없다.
    * 각 코드는 싱글톤이다
        * ex) `KOREA("KO")`
    * 인터페이스는 구현할 수 있다.

* [kotlin enum](../codes/section4/Sec4_6_2_enum.kt)
    * enum의 경우 이미 컴파일 타임에 enum의 개수를 알고 있기 때문에 else를 작성하지 않아도 된다.
    * 만약 else를 작성하지 않았는데, enum class에 더 멤버변수가 남아있다면 warning을 발생시켜준다.

### 6-3) Sealed Class, Sealed Interface

* 문제상황
    * 상속이 가능하도록 추상클래스를 만들까 했는데, 외부에서는 이 클래스를 상속받지 않았으면 좋겠다.
    * 그러면 하위 클래스를 봉인하자.
* Sealed class
    * 컴파일 타임 때 하위 클래스 타입을 모두 기억한다.
    * 즉, 런타임 때, 클래스 타입이 추가될 수 없다.
    * 하위 클래스는 같은 패키지 내에 있어야 한다.
    * Enum과의 차이
        * 클래스를 상속받을 수 있다.
        * 하위클래스는 멀티 인스턴스가 가능하다.

* [Sealed class](../codes/section4/Sec4_6_3_sealedClass.kt)
* when expression을 활용할 때 강점을 발휘한다.
    * 추상화가 필요한 Entity나 DTO에는 sealed class를 적용하면 좋다.
    * JDK17에도 sealed class가 추가됐다.