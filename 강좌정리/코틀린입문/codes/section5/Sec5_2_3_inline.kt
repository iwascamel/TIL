package 강좌정리.코틀린입문.codes.section5

fun main(){
    // 일반적인 방법
    println(3.add2(4))
    // infix
    println(3 add2 4)
}

inline fun Int.add3(other: Int): Int{
    return this + other
}