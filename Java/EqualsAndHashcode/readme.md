# Equals And HashCode

* [Medium : A Deep Dive into Java 8 equals() and hashcode()](./A%20Deep%20Dive%20into%20Java%208%20equals()%20and%20hashcode().md)
*  [EqualsAndHashcode외우기](./EqualsAndHashCode.java)
   *  참조 자료형일 때
   *  [참조](./EqualsAndHashCodeV2.java)

<br/>

> * [참조자료형일 때 equals and hashCode 코드](./EqualsAndHashCodeReferenceType.java)

* 참조자료형일 때
  * Arrays의 경우
    * Arrays.equals를 사용해야한다.
    * hashCode를 생성할 때, `Objects.hash(Arrays.hashCode(멤버변수))` 를 이용해야 한다.
  * Collection Framework같은 경우 Objects.eqauls를 사용하면 된다.

<br/>

* 이 때, `int[]`의 경우 `hashCode`에서 최적화를 위해 31을 Objects.hash()의 결과에 곱해준다.
   * 위의 코드 참조