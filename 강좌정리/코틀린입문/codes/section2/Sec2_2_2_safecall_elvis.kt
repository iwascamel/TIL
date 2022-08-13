fun main(){

    // safe call
    val str: String? = "ABC"
    // 에러: null일수도 있기 때문에
//    println(str.length)

    val str2: String? = "ABC"
    // null이 아닌 경우에만 호출해줘
    println(str2?.length)

    val str3: String? = null
    // null 출력
    // null이면 전체가 null이 됨
    println(str3?.length)

    // safe call과 함께 사용되는 기능: elvis 연산자
    // 앞의 연산결과가 null이면 뒤의 값을 사용한다.
    // 아래에 ?: 연산자가 elvis 연산자
    val str4: String? = "ABC"
    println(str4?.length ?: 0)
}