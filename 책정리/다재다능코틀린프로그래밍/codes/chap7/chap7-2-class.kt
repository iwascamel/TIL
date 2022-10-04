package 책정리.다재다능코틀린프로그래밍.codes.chap7

fun main(){

}

class Car(val yearOfMake: Int, theColor : String){
    var color = theColor
        set(value){
            if(value.isBlank()){
                throw IllegalStateException()
            }
            field = value
        }
}