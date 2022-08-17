package 강좌정리.코틀린입문.codes.section4

fun main(){

}

class House(
    private val address: String,
    private val livingRoom: LivingRoom
){
    // 기본적으로 static으로(바깥 클래스와 연결이 없는) 내부 클래스가 생성된다.
    class LivingRoom(
        private val area: Double
    )
    // 중첩 클래스, java에서 inner 클래스를 선언하고 싶을 때는 inner를 붙여준다.
    inner class LivingRoom2(
            private val area:Double
    ){
        val address: String
        // 클래스 변수를 가져오려면 아래와 같이 this@를 이용한다.
        get() = this@House.address
    }
}