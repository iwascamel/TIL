package 책정리.다재다능코틀린프로그래밍.codes.chap10

/* 229page */
fun main(){

}

fun isPrimeV1(n:Int) = n > 1 && (2 until n).none({i:Int -> n%i == 0})
fun isPrimeV2(n:Int) = n > 1 && (2 until n).none { i: Int -> n % i == 0 }
