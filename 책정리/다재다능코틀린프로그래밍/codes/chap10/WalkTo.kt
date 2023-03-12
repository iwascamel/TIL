package 책정리.다재다능코틀린프로그래밍.codes.chap10

fun main(){
    // i->print(i)
    walkTo(3,::print)
    walkTo(3,::send)
}

fun walkTo(n: Int, action:(Int) -> Unit) = (1..n).forEach(action)
fun send(n: Int) = println(n)

