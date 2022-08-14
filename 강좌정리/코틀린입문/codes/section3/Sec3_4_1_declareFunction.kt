package 강좌정리.코틀린입문.codes.section3

fun main(){

}

// 함수가 하나의 결과값이라면 {} 대신에 = 를 사용할 수 있다.
fun maxV1(a:Int, b:Int) : Int =
    if (a>b){
        a
    }else{
        b
    }

// 인라인으로 사용할 수 있다.
fun maxV2(a:Int, b:Int) : Int = if (a>b){ a }else{ b }

// return이 간단하면 {}를 생략할 수 있따.
fun maxV3(a:Int, b:Int) : Int = if (a>b) a else b

// 반환 타입이 unit이 아니라면 명시적으로 타입을 작성해줘야 한다.
fun maxV4(a:Int, b:Int) = if (a>b) a else b