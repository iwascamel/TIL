package 책정리.다재다능코틀린프로그래밍.codes.chap45

fun main(){
    numberFunc(4)
    numberFunc(3)
    numberFunc(0)
}

fun numberFunc(number: Int): Boolean = when{
    number >= 4 -> false
    number >= 2 -> {
        println("hello")
        println("hello")
        true
    }
    else -> {
        println("no!")
        false
    }
}

fun anyFunction(input: Any) = when(input){
    "A","B" -> "String"
    in 0..100 -> "number"
    else -> "no"
}