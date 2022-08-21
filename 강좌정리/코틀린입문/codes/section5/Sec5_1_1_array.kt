package 강좌정리.코틀린입문.codes.section5

fun main(){
    val arr = arrayOf(100,200)

    // arr.indices -> last index
    for(i in arr.indices){
        println("$i ${arr[i]}")
    }

    // 안먹는다. 왜 안먹지?
    arr.plus(1010)
    for((idx,value) in arr.withIndex()){
        println("$idx $value")
    }

    // Arrays.toString() 과 같음
    println(arr.contentToString())
}