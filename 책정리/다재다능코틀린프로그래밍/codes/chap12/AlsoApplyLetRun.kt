package 책정리.다재다능코틀린프로그래밍.codes.chap12

fun main(){
    val str = "context"
    val result = "RESULT"

    val result1 = str.let{
        result
    }


    println(result1)
}