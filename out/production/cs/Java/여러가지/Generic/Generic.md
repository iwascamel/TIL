# 제네릭: 테코톡

## 1. 제네릭의 사용 이유

1. 컴파일 타임에 타입 체크
2. 캐스팅(타입 변환) 제거

## 2. 변성(variance)

* 공변(Covariance) 이란?

```java
Object[] objectArr = new Integer[1]
```

* 타입 B가 A의 하위타입일 때, `Class<B>`가 `Class<A>`의 하위 타입인 경우
`<? extends T>`

* 무공변(Invariance)
```java
// error!
List<Object> objectList = new ArrayList<Integer>()
```

타입 B가 A의 하위 타입일 때, `Class<B>`가 `Class<A>`의 하위타입인 경우
즉, Class들끼리 아무 관계가 없다.
`<T>`

* 반공변(Contravariance)

타입 B가 A의 하위 타입일 때, `Class<B>`가 `Class<A>`의 상위 타입인 경우
`<? super T>`

## 제네릭 사용 방법 : 클래스, 메서드의 제네릭은 다르다.
* 클래스
```java
public class Person<T>{
	T data
}
```

* 메서드
```java
<T> void print(T t){
	System.out.print(t)
}
```

이 때, 클래스 안에 선언돼 있는 메서드의 <T> 형은 같은 T라고 하더라도 다를 수 있다.

* 예제
```java
public class Main {
    static class Category<T>{
        T t;

        <T> void print(T t){
            System.out.println(this.t.getClass().getName());
            System.out.println(t.getClass().getName());
        }
    }
    static class A{
    }
    static class B{
    }

    public static void 책정리.다재다능코틀린프로그래밍.codes.main(String[] args){
        Category<A> category = new Category<>();
        category.t = new A();
        category.print(new B());
    }
}
```

* 출력
```
src.Main$A
src.Main$B
```

## 제네릭 타입 제한의 필요성
위의 예제에서 category 에는 A와 A의 하위 자식들만 data를 받고 싶을 수 있다.
예를 들면 해당 category가 NoodleCategory라고 해보자. 그러면 Noodle과 관련된 type만 받고 싶을 수 있다.
Coke형이 들어오면 안되게 막고 싶은 것이다.

> 해당 영상에서 
> category -> noodleCateogory
> A -> Noodle 이라고 설명했다.
> 이 설명이 좀 더 직관적이다.

### extends 활용: 상한경계
```java
class NoodleCategory <T extends Noodle>{
	T t;
}
```

이처럼 선언하면 Noodle과 Noodle을 상속받은 type만 제네릭에 넣을 수 있다.
이처럼 위쪽에 제한을 두었다는 의미로 상한경계라는 이름을 붙여준다.

## 와일드 카드
> 코드에서 ? 는 wildcard라고 부른다.

1. `<?>` 

unbounded wildcards
모든 타입이 가능

2. `<? extends Noodle>`

상한경계. Noodle과 Noodle의 하위 자손들만 가능
( ~상한을 둔 경계~ 라고 생각하면 될 것 같다 )

3. `<? super Noodle>`

하한 경계.
Noodle과 Noodle의 부모들만 가능

[image:4F387631-CDE2-4967-9C1E-313659332EBC-4360-0000006D0FFC84BB/95D16DF5-89EE-4A53-B909-EB611F01B3A7.png]

## PECS
> Producer : extends
> Consumer : super

* 많이 헷갈렸는데, 주어가 빠졌다.

> 클래스내에 generic type의 객체가 있을 때
> 해당 객체에 추가/생성할때는 extends를
> 해당 객체를 사용할 때는 super를 사용한다.

> ~핵심은 상위 타입에는 하위 타입의 인스턴스를 넣어도 된다는 것이다.~

### Producer: extends
```java
class Store{
	List<Noodle> noodles = new ArrayList<>()

	void pushNoodle( Collection<? extends Noodle> box){
		for(Noodle n : box){
			noodles.add(n)
		}
	}
}
```

* extends를 하면 어차피 parameter의 generic은 Noodle의 하위타입만 들어오므로 추가해주면 된다.

### Cosumer: super
```java
class Store{
	List<Noodle> noodles = new ArrayList<>()

	void addBox(Collection<? super Noodle> box){
		box.addAll(noodles)
		noodles.clear()
	}
}
```

* super를 하면 parameter의 generic은 Noodle의 상위 타입만 들어오므로 안전하게 해당 noodles를 소비할 수 있다.

<hr/>

## 정리

1. 제네릭은 컴파일 타임에 타입 체크, 캐스팅의 메모리 소모 제거 등을 위해 사용된다.
2. extends, super등은 타입 체크 및 상속 관계에서의 유연성을 위해 사용된다.
3. PECS
	* 핵심은 상위 타입에 하위 타입을 넣는 것은 괜찮다는 것이다.
		* parameter에 List < ? extends Noodle > box 와 같이 선언하면 해당 box 객체에는 Noodle 하위타입만 오게 된다. 그렇기 때문에 Noodle로 선언된 객채 내의 값에 해당 box를 더해줘도 문제가 없다.
		* parameter에 List < ? super Noodle > box 와 같이 선언하면 해당 box 객체에는 Noodle의 상위타입만 오게 된다. 그렇기 때문에 box에 Noodle로 선언된 객체 내의 값을 box에 더해줘도 문제가 없다.

<hr/>

* [YouTube 출처](https://www.youtube.com/watch?v=w5AKXDBW1gQ)


