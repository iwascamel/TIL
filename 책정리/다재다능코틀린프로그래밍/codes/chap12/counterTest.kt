package 책정리.다재다능코틀린프로그래밍.codes.chap12

fun main(){
    var counter = Counter(2)
    println(counter)
    println(++counter)
    println(counter)
    println(counter++)
    println(counter)
    println(counter--)
    println(counter)
}

class Counter(val value: Int){
    operator fun inc() = Counter(value + 1)
    operator fun dec() = Counter(value - 1)
    override fun toString() = "$value"
}