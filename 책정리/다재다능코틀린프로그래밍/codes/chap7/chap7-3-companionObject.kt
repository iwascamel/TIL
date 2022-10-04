package 책정리.다재다능코틀린프로그래밍.codes.chap7

fun main(){
    val coFunc = MachineOperator.coFunc()
    println(coFunc)
    val companion = MachineOperator.Companion
    println(companion)
    // 이름을 붙일시 이름을 통해서만 접근 가능
    CoObject.Factory
}

class CoObject{
    companion object Factory{
        var checkIn = 0
        fun coFunc() = "hello"
    }
}

class MachineOperator(name:String){
    fun checkIn() = checkIn++
    fun checkOut() = checkIn--

    companion object{
        var checkIn = 0
        fun coFunc() = "hello"
    }

}