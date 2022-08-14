package 강좌정리.코틀린입문.codes.section3

fun main(){
    printAll("A","B","C")

    val arr = arrayOf("A","B","C")
    // kotlin에서는 배열을 가변인자를 넣어줄 때 앞에 *를 붙여주어야 한다.
    // spread 연산자
    printAll(*arr)
}

fun printAll(vararg strs: String){
    for(s in strs){
        println(s)
    }
}