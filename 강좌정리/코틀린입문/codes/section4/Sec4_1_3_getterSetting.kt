package 강좌정리.코틀린입문.codes.section4

fun main(){

}

class Person(
        val name:String = "임얼쑤",
        var age: Int = 1
){
    fun isAdult() : Boolean{
        return this.age >= 20
    }

    val isAdultV2: Boolean
    get(){
        return this.age>=20
    }

    val isAdultV3: Boolean
        get() = this.age>=20
}