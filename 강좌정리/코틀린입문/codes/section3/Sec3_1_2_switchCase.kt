package 강좌정리.코틀린입문.codes.section3

// switch 대신 when
// case 대신에 화살표로 분기처리
// default 대신에 else 사용
fun switchCase(score: Int) : String{
    return when(score/9){
        9 -> "A"
        8 -> "B"
        else -> "F"
    }
}

fun switchCaseV2(score: Int) : String{
    return when(score){
        in 90..99 -> "A"
        in 80..89 -> "B"
        else -> "F"
    }
}

fun switchCaseV3(obj : Any) : Boolean{
    return when(obj){
        is String -> obj.startsWith("a")
        else -> false
    }
}

fun switchCaseV4(number: Int) : Boolean{
    return when(number){
        1,0,-1 -> true
        else -> false
    }
}

fun switchCaseV5(number: Int){
    when{
        // 한줄 한줄이 if문처럼 작동
        number == 0 -> println("0")
        number % 2 == 0 -> println("2")
        else -> println("주어지는 숫자는 홀수")
    }
}