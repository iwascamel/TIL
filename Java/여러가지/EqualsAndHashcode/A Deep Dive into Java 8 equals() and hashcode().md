## 1. Hashcode를 왜 사용하는가?

```java
node.hash == hash && (node.key == key || (key != null && key.equals(node.key)))
```

hashcode가 같지 않다면 두 객체는 다른 객체이기 때문에 <u>선행검사</u>로 hashcode를 검사한다.
그렇기 때문에 hashcode를 사용하면 성능상 이점이 있다.

## 2. 만약 eqauls() 만 override 한다면?

만약 아래와 같은 클래스가 있다고 했을 때, index를 기준으로 equals 판단한다고 해보자.

```java
class A{
	int index
}
```

위 클래스의 equals를 override해보자.

```java
int index;

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    A a = (A) o;
    return index == a.index;
}
```

그리고 같은 index를 갖는 객체 2개를 만들어서 HashSet에 넣으면 `set.size()` 는 2가 나온다.
> * [EqualsExample](EqualsExample.java)

이는 hashCode로 선행검사를 해서 같지 않다면 다른 객체로 판단하기 때문이다.
equals를 overriding할거면 hashCode 역시 override해줘야한다.

```other
@Override
public int hashCode() {
    return Objects.hash(index);
}
```

<hr/>

* 출처
  * [A Deep Dive into Java 8 equals() and hashcode()](https://medium.com/geekculture/a-deep-dive-into-java-8-equals-and-hashcode-902990535507)