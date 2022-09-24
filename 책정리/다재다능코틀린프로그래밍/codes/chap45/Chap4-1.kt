package 책정리.다재다능코틀린프로그래밍.codes.chap45

fun main(){
    val oneToFive: IntRange = 1..5
    val aToE : CharRange = 'a' .. 'e'

    // 해당 변수는 val
    for(i in 1..5){
//        i += 3 ERROR!
        print("$i")
    }
    println()
    // downTo
    for(i in 5.downTo(1)){
        print("$i")
    }
    println()
    for(i in 5 downTo 1){
        print("$i ")
    }
    println()
    // until & step
    for(i in 1 until 10 step 2){
        print("$i ")
    }
}