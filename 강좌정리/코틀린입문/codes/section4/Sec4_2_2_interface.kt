package 강좌정리.코틀린입문.codes.section4

// 인터페이스 java랑 똑같이 인터페이스화 불가능!
interface Swimmable{

    // backing field가 없는 property를 interface에 생성가능!
    val believe: Int

    // default 메서드를 구현할 때 default 키워드 없이 구현 가능하다.
    fun act(){
        // 아래에서 구현해 줄 것이라 믿는다.
        // 값을 사용가능하다.
        println(believe)
        println("수영")
    }
    // 추상메서드
    fun breath()
}

interface Flyable{
    val believe: Int
    // 이렇게 직접 넣어줄 수 도 있다.
    // 이러면 하위 상속클래스에서 구현하지 않아도 빨간줄이 뜨지 않는다.
    // 즉, default value가 된다.
    // 당연히 overriding도 된다.
    get() = 3
    fun act(){
        println("fly")
    }
}

class PenguinV2(
    species: String
// , 로 여러 개 override  가능
) : Animal(species,2), Swimmable, Flyable{

    override val believe: Int
        get() = 3

    override fun move() {
        TODO("Not yet implemented")
    }

    override fun act() {
        // java에서는 Swimmable.super.act()
        super<Swimmable>.act()
        super<Flyable>.act()
    }

    override fun breath() {
        TODO("Not yet implemented")
    }
}