# Hashmap & Red black tree ( Medium 글 )

## HashMap 자료구조

### :package: Bucket 

* Bucket이란?
  * HashMap의 Bucket은 key값들의 집합을 의미한다.
  * Bucket의 key에 mapping되는 자료구조는 LinkedList나 Red-Black tree이다.

### HashMap 충돌

key값은 int형이고, 최대 2^32까지만 가능하므로 충돌은 불가피하다.
(최대 2^32이지만, 모든 자료구조마다 2^32를 들고 있기엔 너무 비대하므로 실제 자료구조 사용에서는 2^32보다 작은 값을 들고있다.)

충돌이 일어나면 2가지 해결방법이 있다.
 * Chaning
   * key값이 겹친다면, linkedlist로 잇는 방법
 * Open Addressing(개방 주소법)
   * linear probing
     * 다음 값에 집어넣는다.
   * quadratic
      * 제곱수
    * double
      * 해시 2번 적용

java에서는 기본적으로 chaning을 사용하지만, 길이가 8이상이 되면 Red-Black Tree 자료구조를 사용한다.
LinkedList은 O(n), Red Black Tree는 O(nlogn)이다.

> [Red Black Tree에 대한 설명](./RedBlackTree.md)

## HashCode

HawhCode는 비유를 하자면 생일이라고 하면 될 것 같다. 
생일이 같은 사람이라고 해서 같은 사람인게 아니다.
반면 같은 사람이라고 하면 생일이 같기 때문에, <u>`equals`가 같다면 `hashcode`</u>역시 같아야 한다.

### Put method 시

만약 hashMap에 특정 object를 넣는다고 해보자.
hashMap은 아래와 같이 object의 hashcode를 이용해서 bucket의 값을 만든다.

```java
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```

> [EqualsAndHashCode](EqualsAndHashCode.md)

<hr/>

* 출처
  * [A Deep Dive into Java 8 HashMap](https://medium.com/geekculture/a-deep-dive-into-java-8-hashmap-a976aca22f9b)


