package 책정리.다재다능코틀린프로그래밍.codes.chap9

fun main(){
    ManagerWrapperTest(JavaProgrammer()).takeVacation()
}

class ManagerWrapperTest(val staff:Worker) : Worker by staff{
    override fun takeVacation() {
        println("Manager vacation")
    }
}