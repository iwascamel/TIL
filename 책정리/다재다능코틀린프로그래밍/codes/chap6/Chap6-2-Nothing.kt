package 책정리.다재다능코틀린프로그래밍.codes.chap6

fun main(){
    compute(1)
    compute(-1)
}

fun compute(number: Int){
    if(number>=0){
        println("정상")
    }else{
        throw IllegalArgumentException()
    }
}