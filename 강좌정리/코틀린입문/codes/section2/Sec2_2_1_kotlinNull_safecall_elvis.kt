package 강좌정리.코틀린입문.codes.section2

import java.lang.IllegalArgumentException

fun main(){
    
}

fun startsWithA1_el(str: String?): Boolean{
    return str?.startsWith("a") ?: throw IllegalArgumentException()
}

fun startsWithA2_el(str: String?): Boolean?{
    // null이면 어차피 null이 반환된다.
    return str?.startsWith("a")
}

fun startsWithA3_el(str: String?): Boolean{
    return str?.startsWith("a") ?: false
}
