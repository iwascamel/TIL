package 책정리.effective_kotlin.chap37

import 강좌정리.코틀린입문.codes.section4.Singleton.a

class DeConstructor {
}

fun main(){
    val fullname = FullName("a","b","c")

    val(first,b,c) = fullname

    val user = User("John")
    user.let{a-> println(a) }
    user.let{(a)-> println(a) }
}

data class FullName(
    val first: String,
    val middle: String,
    val last:String
)

data class User(
    val name: String
)

