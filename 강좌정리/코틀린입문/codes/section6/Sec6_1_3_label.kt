package 강좌정리.코틀린입문.codes.section6

fun main(){
    out@ for ( i in 1..5){
        for (j in 1..100){
            println(j)
            if(j == 2){
                break@out
            }
        }
    }
}