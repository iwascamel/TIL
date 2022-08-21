package 강좌정리.코틀린입문.codes.section5

fun main(){
    val str: String = "ABC"
    // 원래 String의 멤버함수 인것처럼 사용이 가능하다.
    println(str.lastChar())
}

// String 클래스를 확장하는 구나
// String -> 수신객체 타입
fun String.lastChar(): Char{
    // this -> 불러진 인스턴스
    // this -> 수신객체
    return this[this.length-1]
}

val String.lastChar: Char
    get() = this[this.length-1]