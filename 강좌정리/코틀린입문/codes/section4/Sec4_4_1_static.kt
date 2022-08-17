package 강좌정리.코틀린입문.codes.section4

fun main(){

}

// 코틀린에는 static 이 없다!
class PersonV4 private constructor(
    var name: String,
    var age: Int
){
    // static 인 것처럼 사용된다.
    companion object{
        // const를 붙여주면 runtime이 아니라 compile time에 할당된다.
        // const -> 진짜 상수에만 붙이기 위한 값
        private const val MIN_AGE = 1
        fun newBaby(name: String) : PersonV4 {
            // java와 마찬가지로 static 변수를 바로 가져와 줄 수 있다.
            return PersonV4(name, MIN_AGE)
        }
    }
}

interface Log{
    fun log()
}

class PersonV5 private constructor(
        var name: String,
        var age: Int
){
    // Factory라는 이름을 붙여보자.
    // 즉, class처럼 이름을 붙일 수 있다.
    companion object Factory : Log{
        private const val MIN_AGE = 1
        fun newBaby(name: String) : PersonV5 {
            return PersonV5(name, MIN_AGE)
        }

        override fun log() {
            TODO("Not yet implemented")
        }
    }
}