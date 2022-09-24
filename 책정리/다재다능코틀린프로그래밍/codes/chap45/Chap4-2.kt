package 책정리.다재다능코틀린프로그래밍.codes.chap45

fun main(){
    val array = arrayOf(10,20,30)

    for(index in array.indices){
        print("${array[index]} ")
    }

    println()

    for((index,value) in array.withIndex()){
        print("$index = $value")
    }
}