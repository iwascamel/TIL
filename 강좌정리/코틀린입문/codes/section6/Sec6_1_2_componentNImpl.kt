package 강좌정리.코틀린입문.codes.section6

class PersonImpl(
    val name: String,
    val age: Int,
){
    // 연산자 오버로딩을 하는 것처럼 간주돼야 한다. -> operator
    operator fun component1() : String{
        return this.name
    }
    operator fun component2() : Int{
        return this.age
    }
}

fun main(){
    val person = Person("얼쑤",100)

//    val (name,age) = person

    // 첫번째 프로퍼티 반환
    val name = person.component1()
    val age = person.component2()
}