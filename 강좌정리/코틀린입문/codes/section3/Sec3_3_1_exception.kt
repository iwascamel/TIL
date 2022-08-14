package 강좌정리.코틀린입문.codes.section3

fun main(){
    parseIntOrThrow("123a")
}

fun parseIntOrThrow(str: String): Int{
    try{
        println(str.toInt())
        return str.toInt()
    }catch(e: IllegalArgumentException){
        throw IllegalArgumentException("${str}은 제대로 된 수가 아닙니다")
    }
}

// try catch 역시 expression이다
fun parseIntOrThrowV2(str: String): Int?{
    return try{
        println(str.toInt())
        str.toInt()
    }catch(e: IllegalArgumentException){
        null
    }
}