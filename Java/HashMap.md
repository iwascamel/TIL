# Hashmap & Red black tree ( Medium 글 )

## HashMap 충돌시

HashMap의 Bucket은 key값들의 집합을 의미한다.

Bucket은 LinkedList나 Red-Black tree로 이루어져있다.

hashMap → chaning, open addressing ( 개방 주소법 ) 중 linear probing이 존재하는 것

Hash충돌이 일어났을 때 Java에서는 Chaning과 Linear Probing(선형탐사) 방법을 사용할 수 있다.

이 때, Java에서는 Chaning 방식을 사용한다.

기본 Chaning은 LinkedList로 동작하고, 길이가 8이상이 되면 Red-Black tree로 변환한다.

LinkedList은 O(n), Red Black Tree는 O(nlogn)이다.

## RedBlackTree

균형이진트리

<img width="350" src="https://res.craft.do/user/full/a1071f7c-889c-0318-fab2-4aba6c1f6845/doc/D9E638B5-C704-4745-A2CB-8343590DBF0B/B9375ABD-ADB2-4F5B-8067-A533C652ECF9_2/Image.png">

위와 같은 극단값이 나올 수 있으므로, 극단값 방지를 위한 이진트리

균형잡힌 트리를 만들기 위해서 특정 조건을 만들어준 이진트리

<img width="700" src="https://res.craft.do/user/full/a1071f7c-889c-0318-fab2-4aba6c1f6845/doc/D9E638B5-C704-4745-A2CB-8343590DBF0B/EE675076-E7BF-4EB4-9D1E-711C14C4EB41_2/Image.png">

아래와 같은 조건을 갖는다.

1. 모든 노드는 색깔을 가져야 한다 red/black
2. root는 반드시 black
3. leaf(none) → black
4. red node의 자식은 반드시 black
5. 각 노드에서 leaf node로 가는 경로가는 black 노드의 개수는 항상 같아야 한다.

---

출처

[자료구조 - 균형탐색이진트리 - Red-Black 트리](https://www.youtube.com/watch?v=SHdYv41iCmE)

## Put method

```other
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```

object의 hashcode를 이용해서 bucket의 값을 만든다.

* 출처
[A Deep Dive into Java 8 HashMap](https://medium.com/geekculture/a-deep-dive-into-java-8-hashmap-a976aca22f9b)

## HashCode에 대한 설명

비유를 하자면 생일이라고 하면 될 것 같다. 생일이 같은 사람이라고 해서 같은 사람인게 아니다.

반면 같은 사람이라고 하면 생일이 같기 때문에, equals가 같다면 hashcode역시 같아야 한다.

## 그렇다면 Hashcode를 왜 사용하는가?

```other
node.hash == hash && (node.key == key || (key != null && key.equals(node.key))
```

hashcode가 같지 않다면 두 객체는 다른 객체이기 때문에 선행검사로 hashcode를 검사한다.

그렇기 때문에 hashcode를 사용하면 성능상 이점이 있다.

## 만약 eqauls() 만 override 한다면?

만약 아래와 같은 클래스가 있다고 했을 때, index를 기준으로 equals 판단한다고 해보자.

```other
class A{
	int index
}
```

위 클래스의 equals를 override해보자.

```other
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

아래와 같이 hashcode역시 override해줘야한다.

```other
@Override
public int hashCode() {
    return Objects.hash(index);
}
```

quadratic → 제곱수

double → 해시 2번 적용

---

* 출처
[A Deep Dive into Java 8 equals() and hashcode()](https://medium.com/geekculture/a-deep-dive-into-java-8-equals-and-hashcode-902990535507)

