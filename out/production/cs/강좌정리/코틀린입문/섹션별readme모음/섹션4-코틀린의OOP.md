# 섹션4 - 코틀린의 OOP

## 1. class

* [class, 생성자](../codes/section4/Sec4_1_1.kt)

### 1-1) class, property

* property란
    * field + getter + setter

* kotlin에서는 field만 만들면 getter, setter를 자동으로 생성해준다.
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

### 1-3) custom getter, setter

### 1-4) backing field

