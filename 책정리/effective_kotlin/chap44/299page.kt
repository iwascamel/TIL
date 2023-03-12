package 책정리.effective_kotlin.chap44

class A{
    val a = 10
}
class B{
    val a = 20
    val b = 30

    fun A.test() = a+b
}

fun main(){
    val a = A()
    val b = B()

    val str1 = "aaa"
    val str2 = "aaa"

    println(str1 == str2) //true
    println(str1 === str2) // false

}