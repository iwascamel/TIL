package 책정리.effective_kotlin.chap43

open class SuperClass

class SubClass: SuperClass()
fun SuperClass.foo() = "super foo"
fun SubClass.foo() = "sub foo"

fun main(){
    val subClass = SubClass()
    println(subClass.foo())
    val superClass = subClass
    println(superClass.foo())
    println(SubClass().foo())
    println((SubClass() as SuperClass).foo())
}