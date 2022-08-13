fun main(){

    // type추론을 통해 변수를 추론한다.
    // 타입을 지정하고 싶다면 아래와 같이 : Long과 같이 지정해준다.
    var number1: Long = 10L

    // java에서의 final
    val number2 = 10L

    // var이든 val이든 값을 할당해주지 않을거면 초기 타입을 명시해주어야 한다.
    val number3: Long
    // val은 초기값에 대해서 딱 한번 값을 할당해줄 수 있다.
    number3 = 10L

    // element
    // java에서 final로 선언된 collection에 대해서 해당 collection자체는 바꾸지 못하지만 메서드를 통해 element를 추가할 수 있는 것처럼
    // val로 선언된 객체에 대해서 element를 추가할 수 있다.

    // tip
    // 모든 변수는 우선 val로 만들고, 꼭 필요한 경우만 var로 변경한다.

    // primitive type
    // 자바에서는 Long long이 있을 때, 연산이 일어나는 경우는 boxing unboxing이 일어나기 때문에 primitive로 선언해서 사용해야 한다.
    // kotling의 경우 내부적으로 알아서 Long -> long으로 바꿔서 연산이 일어나기 때문에 primitive로 바꿔줄 필요없다.
    // 즉 boxing, unboxing을 고려할 필요 없다.

    // null
    // kotlin은 기본적으로 모든 변수가 null이 들어갈 수 없게 설계해놨다.
    // 그래서 null이 들어갈 수 있다면 Long? 과 같이 선언해주어야 한다.
    var nullableVal: Long? = 10L
    nullableVal = null
    
    // kotlin에서는 객체 인스턴스를 할 때 new를 붙이지 않아야 한다.
//    val person = Person("얼쑤")
}