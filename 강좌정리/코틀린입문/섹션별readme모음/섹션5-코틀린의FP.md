# 섹션 5 - 코틀린의 FP

## 1. 코틀린에서 배열과 컬렉션을 다루는 방법

### 1-1) 배열

* [array](../codes/section5/Sec5_1_1_array.kt)
* 배열은 잘 사용되지 않는다.
    * 이펙티브 자바
        * 배열보다 리스트를 사용하라.

### 1-2) Collection. List,Set,Map

#### List

* [list](../codes/section5/Sec5_1_2_list.kt)
* 컬렉션을 만들 때도 불변인지, 가변인지 선언해주어야 한다.

<img width="499" alt="image" src="https://user-images.githubusercontent.com/51740388/185753183-fc839d97-5b1f-495a-963d-723180efc4ce.png">

* list,set,map 각 하위에 mutable 이 하나씩 더 있다.
* 가변(mutable) 컬렉션
    * 우리가 흔히 생각하는 컬렉션
    * 가변적으로 element를 추가 삭제 가능
* 불변(immutable) 컬렉션
    * element 추가 삭제 불가능
    * 그러나 reference type인 element의 필드는 변경될 수 있다.

<img width="400" alt="image" src="https://user-images.githubusercontent.com/51740388/185753306-7a56d1f1-927b-4e4d-929f-655e94d58d52.png">

<img width="400" alt="image" src="https://user-images.githubusercontent.com/51740388/185753315-55f33582-ea0f-4c58-9421-51a639d548ac.png">

* money 자체는 변경될 수 없지만, money내부의 필드값은 변경될 수 있다.

* 즉, Collection을 만들자마자, `Collections.unmodifiableList()` 등을 붙여준 게 불변이다.
* TIP
    * 우선 불변 리스트를 만들고, 꼭 필요한 경우 가변 리스트로 바꾸자.
    * 그래야 코드도 깔끔해지고, 불필요한 가변 리스트 사용이 줄어들기 때문이다.

#### Set(집합), Map

* [set,map](../codes/section5/Sec5_1_2_set_map.kt)

### 1-3) Collection nullable, java와 함께 사용하기

* `List<Int?>`
    * 리스트에 null이 들어갈 수 있지만 리스트는 절대 null이 아니다.
* `List<Int>?`
    * 리스트는 null일 수 있지만, 리스트에는 null이 들어갈 수 없다.
* `List<Int?>?`
    * 리스트에 null이 들어갈 수도 있고, 리스트가 null일 수도 있다.

* java의 경우 읽기 가능 컬렉션과 변경 가능 컬렉션을 구분하지 않는다.
    * java는 nullable과 non-nullable를 구분하지 않는다.

<img width="500" alt="image" src="https://user-images.githubusercontent.com/51740388/185773701-d19c1f2b-c3ac-4581-a8c3-8fd52b268f87.png">

<img width="400" alt="image" src="https://user-images.githubusercontent.com/51740388/185773712-d74fa728-e352-44eb-b549-244e67c71bf3.png">

<img width="500" alt="image" src="https://user-images.githubusercontent.com/51740388/185773723-5eb7e2bb-6295-4901-9eaf-4b3e572ea806.png">

* 그래서 kotlin쪽의 컬렉션이 java에서 호출되면 컬렉션 내용이 변하게 될 수 있음을 감안해야 한다.
    * 코틀린 쪽에서 `Collections.unmodifableXXX()` 를 활용하면 변경 자체를 막을 수는 있다.

* kotlin에서 java 컬렉션을 가져다 쓸 때는 플랫폼 타입을 신경써야 한다.

<img width="600" alt="image" src="https://user-images.githubusercontent.com/51740388/185773749-5b0f1bda-af75-49b8-b63d-77f2d363d2ca.png">

* 해결방법
    * java 코드를 보며 맥락을 확인하고, java 코드를 가져오는 지점을 wrapping해서 영향 범위를 최소화하자.

## 2. 코틀린에서 다양한 함수를 다루는 방법

### 2-1) 확장함수

* [확장함수](../codes/section5/Sec5_2_1_expentionFunction.kt)

* 등장배경
    * kotlin은 java와 100%호환을 목표로 하고 있다.
    * 그렇다면 기존 java코드 위에 자연스럽게 코틀린 코드를 추가하는 방법은 없을까?
    * 즉, java 코드를 유지보수 및 확장할 때 코틀린 코드를 덧붙이고 싶다는 수요가 생겼다.
* 함수를 클래스 밖에 만들되, 어떤 클래스 안에 있는 멤버 함수처럼 호출할 수 있게 만들어주자.

* 확장함수가 public이고, 확장 함수에서 수신 객체 클래스의 private함수를 가져오면 캡슐화가 깨지는 거 아닌가?
    * 확장함수에서는 클래스에 있는 private, 또는 protected 멤버를 가져올 수 없다.
* 멤버 함수와 확장함수의 시그니처가 같다면?
    * 확장 함수와 멤버 함수의 시그니처가 동일하다면(메서드가 동일) 멤버함수가 우선적으로 호출된다.
* 확장함수가 overriding 된다면?
    * [overriding](../codes/section5/Sec5_2_1_expentionFunction_overriding.kt)

* 정리
    * 확장함수는 원본 클래스의 private, protected 멤버 접근이 안된다.
    * 멤버함수, 확장함수 중 멤버함수에 우선권이 있다.
    * 확장함수는 현재 타입을 기준으로 호출된다.
  
* java에서 kotlin의 확장함수를 가져다 쓸 수 있나?
    * java에서는 정적 메서드를 부르는 것처럼 사용가능하다.
    * `해당 파일의 이름.메서드명()` 으로 사용 가능하다.
    * ex) `Sec5_2_1_expentionFunction.lastChar()`

* 프로퍼티로 확장할 수도 있다.
    * 즉 `fun String.lastChar()` 을 `val String.lastChar()`로 만들면 확장 프로퍼티로 생성된다.
    * [프로퍼티 확장](../codes/section5/Sec5_2_1_expentionFunction.kt)

### 2-2) infix 함수

* 중위 함수
    * 함수를 호출하는 새로운 방법
    * ex) downTo, step
* `변수.함수이름(argument)` 형식 대신, `변수 함수이름 argument` 형식으로 호출한다.
* [infix](../codes/section5/Sec5_2_2_infix.kt)

### 2-3) inline 함수

* 함수의 코드를 호출하는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복붙하고 싶은 경우

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/185774625-2c70f3ca-461e-4980-aff0-4bbb2158fcf3.png">

* 위처럼 Int.add함수의 코드가 main안으로 복사 붙여넣기가 됐다.
    * 함수를 parameter로 전달할 때, 오버헤드를 줄일 수 있다. 즉, 함수가 함수를 부르다보면 call chain에 오버헤드가 발생할 수 있다.
    * 하지만 inline함수의 사용은 성능 측정과 함께 신중하게 사용돼야 한다.
    * kotlin 함수에서는 내부적으로 어느정도 최적화가 돼 있기 때문에 inline이 적절히 붙어있다.

### 2-4) 지역함수

* 함수 안에 함수를 선언할 수 있다.
    * 함수의 중복이 발생하거나 하는 등의 이유로 함수로 추출하면 좋은 것 같은데, 해당 함수를 지금 함수 내에서만 사용하고 싶은 경우 사용하면 된다.
    * 즉 fun 안에 fun이 존재하는 형태
    * 그러나 depth가 깊어지기도 하고, 코드가 그렇게 깔끔해지지는 않는다.
    * 그래서 권장되지는 않는다.

## 3. 코틀린에서 lambda를 다루는 방법

### 3-1) java에서 람다를 다루기 위한 노력

* 요구사항이 자꾸 변경되는 경우 유연하게 대응하기 어렵다.
    * 그래서 인터페이스와 익명클래스를 이용하려는 시도가 생겼다.
    * 그러나 인터페이스나 익명클래스는 기본적으로 코드가 길 뿐더러, filter의 다양한 조건들에 대해 유연하게 대처하기 힘들었다.
    * 그래서 JDK8부터 lambda(이름없는 함수)가 등장했다.
* java에서는 메서드 자체를 직접 넘겨주는 것 **처럼** 사용할 수 있다.
    * 왜 처럼이냐면, argument로 `Fruit::isApple` 해당 사항처럼 넘길 때 해당 메서드를 받는 것은 interface이기 때문이다.
* java에서는 함수는 2급 시민이다.
    * 변수에 직접 할당되거나, parameter로 전달될 수 없다.

### 3-2) kotlin에서 lambda

* [람다](../codes/section5/Sec5_3_2_lambda.kt)
* kotlin에서는 함수가 그 자체로 값이 될 수 있다.
    * 즉, 1급 시민이다.([First class Citizen](https://medium.com/@lazysoul/functional-programming-%EC%97%90%EC%84%9C-1%EA%B8%89-%EA%B0%9D%EC%B2%B4%EB%9E%80-ba1aeb048059))

### 3-3) Closure

<img width="600" alt="image" src="https://user-images.githubusercontent.com/51740388/185775427-dca62f59-1fc6-4c10-bca4-9e9758c2ec20.png">

<img width="500" alt="image" src="https://user-images.githubusercontent.com/51740388/185775435-27f215c5-b8d3-438d-bf66-3e0ce177898f.png">

* 코틀린에서는 lambda가 시작하는 시점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 갖고 있다.
    * 위의 예제에서는 `it.name == targetFruitName` 이라는 함수가 호출되는 시점에 존재하는 `targetFruitName`을 포획해서 정보를 갖고 있는다.
    * 람다가 사용되는 해당 시점에 람다가 쓰고 있는 다른 변수들을 모두 갖고 있어야만 진정한 1급 시민으로 쓸 수 있기 때문이다.
    * 해당 데이터 구조를 Closure라고 부른다.

### 3-4) try with resources

* [use함수 분석](../codes/section5/Sec5_3_4_tryWithResource.kt)

* section3에서 보았던 java에서의 tryWithResource를 kotlin에서는 use를 이용한 함수를 보자.

```kotlin
public inline fun <T : Closeable?, R> T.use(block: (T) -> R): R {
    ...
}
```

* Closeable을 상속받고(`(T : Closeable?)`) , Closeable을 상속받은 함수를 확장한 함수(`T.use`)라는 것을 알 수 있다.
* inline함수이다.
* 받고 있는 parameter가 block이라는 이름을 가진 함수다.
    * T타입을 받고, R타입을 반환한다.
    * 즉, lambda를 받도록 만들어진 함수다.

### 3-5) 정리

* 코틀린에서 lambda는 2가지 방식으로 만들 수 있다.
    * {} 방법이 좀 더 보편적으로 사용된다.
* 함수를 호출할 때, 마지막 parameter가 람다를 받는 함수일 경우에는 해당 argument를 소괄호 밖으로 뺄 수 있다.
* 람다의 마지막 expression결과는 lambda의 반환값이다.
* 코틀린에서는 closure을 사용하여 non-final 변수도 람다에서 사용할 수 있다.

## 4. 코틀린에서 컬렉션을 함수형으로 다루는 방법

### 4-1) 필터와 맵

* [collection using lambda filter map](../codes/section5/Sec5_4_1_lambda_map_filter.kt)

### 4-2) 다양한 컬렉션 처리 기능

* all
    * 조건이 모두 만족하면 true
    * ex) `fruits.all{람다함수}`
* none
    * 모두 불만족하면 true
* any
    * 하나라도 만족하면 true
* count()
* sortedBy
    * sortedByDescending
* distinctBy
    * 변형된 값을 기준으로 중복을 제거
* first()
    * 무조건 null이 아니어야 한다.
    * firstOrNull
        * 첫번째 값 혹은 null
    * last
        * lastOrNull

### 4-3) List를 Map으로

* [listToMap](../codes/section5/Sec5_4_3_listToMap.kt)

### 4-4) 중첩된 컬렉션 처리

* flatMap, flatten

<img width="600" alt="image" src="https://user-images.githubusercontent.com/51740388/185777435-8d3e30b1-6647-4a85-8fa7-3b51919edb75.png">