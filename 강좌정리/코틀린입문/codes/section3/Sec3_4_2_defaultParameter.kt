package 강좌정리.코틀린입문.codes.section3

fun main(){

}

// 기본값 지정이 가능하다.
fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true){
    for(i in 1..num){
        if(useNewLine){
            println(str)
        }else{
            println(str + "none")
        }
    }
}

// 개행을 하면 가독성이 좋아진다.
fun repeatV2(
        str: String,
        num: Int = 3,
        useNewLine: Boolean = true
){
    for(i in 1..num){
        if(useNewLine){
            println(str)
        }else{
            println(str + "none")
        }
    }
}