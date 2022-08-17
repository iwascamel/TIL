package 강좌정리.코틀린입문.codes.section4

fun main(){
}

// data class에서는 자동으로 equals, hashCode, toString을 만들어준다.
data class PersonDto(
        val name: String,
        val age: Int
)