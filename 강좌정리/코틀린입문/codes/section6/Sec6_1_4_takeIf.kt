package 강좌정리.코틀린입문.codes.section6

fun main(){

}

fun getNumberOfNull(number: Int): Int?{
    return if(number > 0){
        number
    }else{
        null
    }
}

fun getNumberOfNullV2(number: Int): Int?{
    // 조건을 만족하면 그 값이
    // 아니라면 null이 반환된다.
    // takeUnless도 존재한다.takeIf와 반대로 동작한다.
    return number.takeIf { it > 0 }
}