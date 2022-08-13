package 강좌정리.코틀린입문.codes.section2

fun main(){
    
}

fun startsWithA1(str: String?): Boolean{
    if( str == null){
        throw IllegalArgumentException("null")
    }
    return str.startsWith("a")
}

fun startsWithA2(str: String?): Boolean?{
    if( str == null){
        return null
    }
    return str.startsWith("a")
}

fun startsWithA3(str: String?): Boolean{
    if( str == null){
        return false
    }
    return str.startsWith("a")
}

fun startsWithA4(str: String?){
    // error
    // null 체크 해주어야 한다.
//    return str.startsWith("a")
}