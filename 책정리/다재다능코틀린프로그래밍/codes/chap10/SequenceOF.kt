package 책정리.다재다능코틀린프로그래밍.codes.chap10

fun main(){
    var factor = 2
    val doubled = listOf(1,2).map{it * factor}
    val doubledTwo = sequenceOf(1,2).map{it * factor}
    doubledTwo.forEach { println(it) }
    factor = 0
    doubled.forEach { println(it) }
    doubledTwo.forEach { println(it) }
}