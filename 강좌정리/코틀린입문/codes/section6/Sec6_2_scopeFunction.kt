package 강좌정리.코틀린입문.codes.section6

fun main(){
    val strings = listOf("ap","bc")
    val str = "abc"

    strings.map{it.length}
            .filter{it>3}
            .let{lengths -> println(lengths)}

    // 가장 많이 사용
    val length = str?.let {
        println(it.uppercase())
        it.length
    }
}

fun printPerson(person: Person?){
    person?.let{
        println(person.name)
        println(person.age)
    }
    // 위 아래는 동치
    if(person != null){
        println(person.name)
        println(person.age)
    }
}