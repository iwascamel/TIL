package 강좌정리.코틀린입문.codes.section6

data class Person(
    val name: String,
    val age: Int,
)

fun main(){
    val person = Person("얼쑤",100)

//    val (name,age) = person

    // 첫번째 프로퍼티 반환
    val name = person.component1()
    val age = person.component2()
}