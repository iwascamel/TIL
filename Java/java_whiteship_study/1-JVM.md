# JVM 관련 정리

## 1. compile

### 1-1) compile & execute

1. .java 파일 생성
2. java compiler인 javac.exe를 통해 .java파일 컴파일
   * .class 파일 생성
   * JVM이 읽을 수 있는 byte code가 생성된다.
     * 컴퓨터가 읽으려면 binary code로 변환해야 한다. JVM이 이 작업을 수행한다.
3. .class파일을 java.exe 를 실행한다.
   * 그러면 class loader에 의해 JVM영역으로 해당 파일이 가져와진다.
4. JVM의 byte code verifier에서 해당 바이트코드를 검증한다.
5. JVM내부의 interpreter가 코드를 한 줄, 한 줄 읽으면서 byte code를 binary code로 변환한다.
   * binary code는 JVM의 class 영역에 저장된다.
6. Runtime으로 코드가 실행된다.

### 1-2) javac option

* -source
  * 내가 작성한 소스코드의 level을 명시
* -target
  * 해당 코드가 실행되고자 하는 버전의 이상버전을 명시
  * ex) -target 1.6
    * jvm 6버전이후부터 실행

<hr/>

* [1-2)javac option](https://stackoverflow.com/questions/10663450/whats-the-difference-between-source-and-target-compatibility)
* [주 참조](https://five-cosmos-fb9.notion.site/java-JVM-1238f12eccff4b67be263cd4a5b7dbbe)