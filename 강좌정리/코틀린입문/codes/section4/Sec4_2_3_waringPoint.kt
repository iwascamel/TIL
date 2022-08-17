package 강좌정리.코틀린입문.codes.section4

fun main(){
    baseChild(300)
}

// 하위 클래스에서 상속받게 클래스를 설정하려면 open을 명시해주어야 한다.
open class Base(
    // open 문제!
    open val number:Int = 100
){
    init {
        println("Base class")
        // 상위클래스를 호출하게 되면 하위클래스에 있는 number를 가져오게 된다.
        // 즉, 초기화된 값을 호출하게 되고, 0을 가져오게 된다.
        println(number)
    }
}

class baseChild(
    override val number: Int = 1
) : Base(number){
    init{
        println("base child")
    }
}