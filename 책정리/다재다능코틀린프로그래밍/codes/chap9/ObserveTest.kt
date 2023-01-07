package 책정리.다재다능코틀린프로그래밍.codes.chap9

import kotlin.properties.Delegates.observable

fun main(){
    println(count)
    count++
    println(count)
    count--
    println(count)
}


var count by observable(0){
        property, oldValue, newValue ->
    println("property = $property , oldValue = $oldValue, newValue = $newValue")
}
