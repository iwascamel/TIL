package 강좌정리.코틀린입문.codes.section3

// Unit(void) 생략
fun validate(score: Int){
    if( score < 0 ){
        // new 사용 x
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    }
}

fun getPassOrFail(score: Int) : String{
    return if(score >=50){
        "P"
    }else{
        "F"
    }
}

fun validateScoreUsingIn(score: Int) : String{
    return if(score in 70..100){
        "P"
    }else{
        "F"
    }
}