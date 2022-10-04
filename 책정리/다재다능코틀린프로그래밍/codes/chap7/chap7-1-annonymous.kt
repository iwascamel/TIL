package 책정리.다재다능코틀린프로그래밍.codes.chap7

fun main(){
    drawCircle()
}

fun drawCircle(){
    val circle = object{
        val x = 10
        val y = 20
    }
    println("${circle.x} ${circle.y}")
}

fun craeteRunnable(): Runnable{
    val runnable = object: Runnable{
        override fun run() {
            println("yeah...")
        }
    }
    return runnable
}

fun craeteRunnableV2(): Runnable{
    val runnable = Runnable { println("yeah...") }
    return runnable
}