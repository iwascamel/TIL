package 책정리.다재다능코틀린프로그래밍.codes.chap7

fun main(){

}

class CarV2(val yearOfMake: Int, theColor : String){
    var fuelLevel = yearOfMake
        private set
    var color = theColor
        set(value){
            if(value.isBlank()){
                throw IllegalStateException()
            }
            field = value
        }
    init{
        if(yearOfMake>2000) fuelLevel = -1
    }
}

class CarV3(val yearOfMake: Int, theColor : String){
    var fuelLevel = if(yearOfMake>2000) -1 else yearOfMake
        private set
    var color = theColor
        set(value){
            if(value.isBlank()){
                throw IllegalStateException()
            }
            field = value
        }
}