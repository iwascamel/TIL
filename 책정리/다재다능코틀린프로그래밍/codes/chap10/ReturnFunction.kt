package 책정리.다재다능코틀린프로그래밍.codes.chap10

fun main(){
    val names = listOf("Pam", "Pat", "Paul", "Paula")
    println(names.find(predicateOfLength(5)))
    println(names.find(predicateOfLength(4)))
}

fun predicateOfLength(length: Int) : (String) -> Boolean{
    return {input: String -> input.length == length}
}