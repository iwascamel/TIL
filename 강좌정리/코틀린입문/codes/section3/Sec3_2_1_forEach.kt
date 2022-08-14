package 강좌정리.코틀린입문.codes.section3

fun main(){
    printForEach()
    printStandardFor()
    printStandardForDownTo()

}

private fun printStandardFor() {
    for (i in 1..5 step 2) {
        println(i)
    }
}

private fun printStandardForDownTo() {
    for (i in 5 downTo 1 step 2) {
        println(i)
    }
}

private fun printForEach() {
    val numbers = listOf(1, 2, 3)

    for (number in numbers) {
        println(number)
    }
}