package 책정리.다재다능코틀린프로그래밍.codes.chap9

import kotlin.properties.Delegates.vetoable

fun main(){
    println(count2)
    count2++
    println(count2)
    count2--
    println(count2)
}

var count2 by vetoable(0){
    _, oldValue, newValue -> newValue > oldValue
}