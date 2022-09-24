package 책정리.다재다능코틀린프로그래밍.codes.chap6

fun main(){

}

class Animal(val age: Int){
    override operator fun equals(other: Any?): Boolean{
        return if (other is Animal) age == other.age else false
    }
    // 더 간단하게 equals 구현
    fun equalsV2(other: Any?): Boolean{
        return other is Animal && age == other.age
    }

    fun stringWhenTest(inputString: Any) = when(inputString){
        is String -> "String 입니다"
        else -> "String이 아닙니다"
    }
}