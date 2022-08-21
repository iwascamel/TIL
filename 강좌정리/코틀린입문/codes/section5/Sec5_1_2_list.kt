package 강좌정리.코틀린입문.codes.section5

fun main(){
    // 가변 list 선언
    // 불변 리스트는 listOf()
    // mutalbeListOf같은 경우 ArrayList가 기본 구현체다.
    val numbers = mutableListOf(100,200)
    numbers.add(300)

    // 만약 empty로 만들거면 type을 명시해주어야 한다.
    // 단, 유출될 수 있으면 생략할 수 있다.
    val emptyList = emptyList<Int>()

    // 예를 들어 아래와 같이 넘겨도 에러가 뜨지 않는다. 추론이 가능하기 때문이다.
    printNumbers(emptyList())

    println(numbers[0])

    for(number in numbers){
        println(number)
    }

    for((idx,value) in numbers.withIndex()){
        println("$idx $value")
    }
}

private fun printNumbers(number: List<Int>){

}