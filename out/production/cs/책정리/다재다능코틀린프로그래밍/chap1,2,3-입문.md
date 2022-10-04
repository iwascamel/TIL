# part1 - 코틀린으로 스크립팅 하기

> chap1 ~ chap6

## chap1. 코틀린 시작하기

* 코틀린
    * 코틀린은 아주 강력한 타입 추론 능력을 갖춘 정적 타입 언어다.
* 코틀린 시작
    * SDK가 필요하다.
    * Intellij IDEA에서는 코틀린이 IDEA와 함께 설치된다.

## chap2. 코틀린 필수사항

* 코틀린은 어떠한 예외도 처리하도록 강제하지 않는다.
* 코틀린의 이름이 타입보다 먼저 나오는 것은, 변수의 이름이 타입보다 중요하다는 것을 시사한다.
* 코틀린의 == 는 java의 equals를 의미하고, ===는 java의 ==연산과 일치한다.
* 코틀린은 null을 안전하게 다룬다.
* `println(null == null)` 을 하면 true가 나온다.

## chap3. 함수를 사용하자.

### 3-1) 이모저모

* 코틀린에서는 단독함수를 클래스 안의 정적 메서드로 만들 필요가 없다. 언어의 제약 때문에 객체지향인척 할 필요가 없다.
* KISS(Keep It Simple Stupid!)
* 리턴타입 추론
    * [code참조](./codes/Chap123.kt)
* 함수 할당시, =과 {} 블록 바디를 함께 사용하지 마라.

### 3-2) default argument

* java에서는 parameter추가에 대한 확장안으로, overloading을 사용한다.
* kotlin에서는 default argument로 해당 문제를 해결한다.
    * 이 때, default argument의 위치는 관용적으로 뒤에 있어야 한다.
        * lambda 표현식이 있다면, lambda 표현식 앞에 위치시켜라.
* default argument를 활용할 수 있다.
    * [code참조](./codes/chap123/Chap123.kt)

### 3-3) vararg(다중인자), spread

#### vararg

* println()은 여러개의 인자를 받는다.
* [vararg 예제코드 참조](./codes/chap123/Chap123.kt)
    * vararg를 사용할 때는 항상 마지막에 사용하라.
    * 마지막 파라미터가 람다표현식일 경우, 마지막 바로 전에 둔다.

#### spread

* [spread 예제코드 참조](./codes/chap123/Chap123.kt)
* vararg에 배열을 넘길 경우, 배열 앞에 *를 붙여주면 된다.
    * *를 spread연산자라고 한다.
* list의 경우 toIntArray()를 통해 array를 만들어준다.

### 3-4) 구조분해

* 한 줄로 여러 개의 input을 받을 수 있다.
* [구조분해 코드 참조](./codes/chap123/Chap123.kt)
* 값 무시
    * `val(first, _, third) = getFullName()`
    * 값을 무시하고 싶다면 `_`를 적어주며 된다.
    * 만약 이후의 값을 무시하고 싶다면, 그냥 아무것도 적지 않으면 된다.
    * `val(_, second) = getFullName()`
        * second는 3개 중, 2번째 값이 호출된다.