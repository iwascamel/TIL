package 책정리.effective_kotlin.chap47

import 강좌정리.코틀린입문.codes.section4.Singleton.a

fun main(){
    sequenceOf(1,2,3)
        .filter { println("First $it"); it % 2 ==1 }
        .map { println("Middle $it"); it *2}
        .forEach { println("Last $it") }


    println("-----")

    listOf(1,2,3)
        .filter { println("First $it"); it % 2 ==1 }
        .map { println("Middle $it"); it *2}
        .forEach { println("Last $it") }

}


