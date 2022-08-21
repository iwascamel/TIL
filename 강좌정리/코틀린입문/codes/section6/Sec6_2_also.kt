package 강좌정리.코틀린입문.codes.section6

fun main(){
    mutableListOf(1,2,3)
            .also{ println("$it")}
            .add(4)

    // java 개발자의 경우 아래가 익숙할 것
    val numbers = mutableListOf(1,2,3)
    println("$numbers")
    numbers.add(4)
}