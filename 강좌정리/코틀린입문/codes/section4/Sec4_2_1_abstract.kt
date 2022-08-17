package 강좌정리.코틀린입문.codes.section4

// java와 kotlin경우 모두 추상클래스는 인스턴스화 할 수 없다.
abstract class Animal(
        protected val species: String,
        protected open val legCount: Int
){
    abstract fun move()
}

class Cat(
    species: String
// 상속의 경우 : 한칸 띄워서 적으면 상속이다.
// 어떤 클래스를 상속받을 때 무조건 상위 클래스의 생성자를 바로 호출해야 한다.
) : Animal(species,4){
    // override 필수적으로 붙여주어야 한다.
    override fun move() {
        println("move cat")
    }
}

class Penguin(
    species: String
) : Animal(species,2){
    private val wingCount: Int = 2

    override fun move() {
        println("move penguin")
    }

    // property에 대해서 override한다면 상위 클래스에 open이 붙어있어야 한다.
    override val legCount: Int
    get() = super.legCount + this.wingCount
}