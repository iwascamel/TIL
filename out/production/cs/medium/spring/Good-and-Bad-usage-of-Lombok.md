# Good and Bad usage of Lombok

## 1. what is lombok

* You add some annotations and Lombok generate codes for you at the compile-time.
  * 컴파일 타임에 코드를 생성해준다.

## 2. how lombok works

* there are three main steps in the process
  1. Parse and Enter
  2. Annotation Processing
  3. Analyse and generate

## 3. bad usage of lombok

* Developers forget that Lombok generates codes because it is not visible in our source code.
  * 롬복은 코드가 시각적으로 보이지 않기 때문에 종종 자기가 어떤 코드를 사용했는 지 까먹는다.

* 예시로 DTO에 @Data annotation을 쓸 수 있다.
  * 이 때 관과할 수 있는 것은 eqauls, hashCode, toString 등도 같이 생성된다는 것이다.
  * 그러나 해당 코드들을 사용하지 않는다.
  * Our code repository should not have anything that we don’t use.
    * 사용하지 않는 것들은 가지고 있어선 안된다.
  * 그렇기 때문에 @Data annotation을 쓰지 말고, 위 상황에서는 @Getter와 @Setter만 사용해야 한다.

<hr/>

* [Good and Bad usage of Lombok](https://medium.com/geekculture/good-and-bad-usage-of-lombok-8c8f70874a93)
* date
  * 22.07.14

