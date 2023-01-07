package 책정리.다재다능코틀린프로그래밍.codes.chap9

fun main(){
    val manager = CManager(CWorkerImpl1())
    manager.work()
    manager.staff = CWorkerImpl2()
    manager.work()
}

interface CWorkerInterface{
    fun work()
}

class CWorkerImpl1: CWorkerInterface{
    override fun work() = println("worker1")
}

class CWorkerImpl2: CWorkerInterface{
    override fun work() = println("worker2")
}

class CManager(var staff:CWorkerInterface): CWorkerInterface by staff