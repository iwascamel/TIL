package 강좌정리.코틀린입문.codes.section4

sealed class HyundaiCar(
    val name: String,
    val price: Long
)

class Avante : HyundaiCar("아반뗴",1000L)
class Sonata : HyundaiCar("소나타",2000L)
class Granduer : HyundaiCar("그랜져",3000L)

fun main(){
    handleCar(Avante())
}

private fun handleCar(car: HyundaiCar){
    when(car){
        is Avante -> println()
        is Granduer -> println()
        is Sonata -> println()
    }
}