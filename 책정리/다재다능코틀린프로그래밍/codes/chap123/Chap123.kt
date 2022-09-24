package 책정리.다재다능코틀린프로그래밍.codes

fun main(){
    // 2) null == null => true
    println(null == null)
    // 3-1) {} 없이 함수 사용 가능. 타입추론.
    val message: String = greet()
    println(message)

    // 3-2) default argument 활용
    defaultArgumnetUtilizing(name="yo")

    // 3-3) vararg
    println(maxFunction(1,2,3,4))

    // 3-3) vararg
    println(greetMany("Hello","A","B","C"))

    // 3-3) spread
    println(maxFunction(*intArrayOf(1,2,3,4)))
    println(maxFunction(*listOf(1,2,3,4).toIntArray()))

    // 3-4) 구조분해
    val (first, second, third) = getFullName()
    println("$first $second $third")
}

fun greet() = "hello"
fun getFullName() = Triple("John","Kelly","Mayer")

// 3-2)
fun defaultArgumnetUtilizing(name: String, msg: String = "Hi my name is $name"){
    println(msg)
}

// 3-3)
fun maxFunction(vararg numbers: Int): Int{
    var large = Int.MIN_VALUE
    for(number in numbers){
        large = if(number > large) number else large
    }
    return large
}

fun greetMany(msg: String, vararg names: String){
    println("$msg ${names.joinToString(",")}")
}