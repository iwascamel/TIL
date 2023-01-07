package 책정리.다재다능코틀린프로그래밍.codes.chap9


fun main(){
    val manager = Manager()
    manager.work()
    val manager2 = Manager2(JavaProgrammer())
    manager2.meeting()
}

interface Worker{
    fun work()
    fun takeVacation()
}

class JavaProgrammer: Worker{
    override fun work() {
        println("writer java")
    }

    override fun takeVacation() {
        println("rest in java peace")
    }
}

class CSharpProgrammer: Worker{
    override fun work() {
        println("writer csharp")
    }

    override fun takeVacation() {
        println("rest in charp beach")
    }
}

class Manager() : Worker by JavaProgrammer()

// 외부 위임을 통해 추가 함수를 손쉽게 구현할 수 있다.
class Manager2(private val staff:Worker) : Worker by staff{
    fun meeting() = println("${staff.javaClass.simpleName}meeting")
}