package 책정리.다재다능코틀린프로그래밍.codes.chap9

fun main(){

}

interface MultiWorker{
    fun work()
    fun takeVacation()
    fun greet() = println("worker hi")
}

interface MultiBoss{
    fun rest()
    fun greet() = println("boss hi")
}

class MultiManager(val staff: MultiWorker, val boss:MultiBoss): MultiWorker by staff, MultiBoss by boss{
    // override하지 않으면 에러 발생
    override fun greet() {
        TODO("Not yet implemented")
    }
}

