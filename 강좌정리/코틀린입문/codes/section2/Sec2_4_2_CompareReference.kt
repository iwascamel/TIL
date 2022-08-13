package 강좌정리.코틀린입문.codes.section2

fun main(){
    val money1 = JavaMoney(1000)
    val money2 = JavaMoney(2000)

    // java에서 money1.compareTo(money2) 가 호출됨
    // 자동으로 compareTo가 호출
    if(money1 < money2){
        println("money2가 더 크다")
    }
}