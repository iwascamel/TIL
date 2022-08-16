package 강좌정리.코틀린입문.codes.section4

fun main(){

}

class PersonV3(val name:String, nickname: String){
    fun getUpperCaseName():String{
        return this.name.uppercase()
    }

    val upperCaseNameV2:String
    get() = this.name.uppercase()

    var nickname = nickname
    set(nickname){
        field = nickname.uppercase()
    }
}