package 강좌정리.코틀린입문.codes.section4

fun main(){

}

class PersonV2(name: String){
    val name = name
    get() = field.uppercase()
}