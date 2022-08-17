package 강좌정리.코틀린입문.codes.section4

fun main(){
    moveSomething(object : Movable{
        override fun move() {
            println("move")
        }

        override fun fly() {
            println("fly")
        }
    })
}

public interface Movable{
    fun move()
    fun fly()
}

private fun moveSomething(movable: Movable){
    movable.move()
    movable.fly()
}