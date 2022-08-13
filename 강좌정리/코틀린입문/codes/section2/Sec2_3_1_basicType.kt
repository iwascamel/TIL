package 강좌정리.코틀린입문.codes.section2

fun main(){

    // java와 동일하게 타입이 있지만, Int Long Float Double이 가장 많이 쓰인다.
    // java -> 기본 타입값 간의 변환은 암시적으로 이루어질 수 있다.
    // kotlin -> 명시적으로 이루어져야 한다.
    val num1 = 4
    val num2: Long = num1.toLong()
    println(num1+num2)

    val num3 = 3
    val num4 = 5
    // toDouble안해주면 int형 값으로 출력
    val divide = num3 / num4.toDouble()
    println(divide)

    // null 발생시 safe call과 elvis 연산자로 처리
    var num5: Int? = 3
    var num6: Long = num5?.toLong() ?: 0L
}

