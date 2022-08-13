package 강좌정리.코틀린입문.codes.section2

fun main(){
    // java에서는 StringBuilder를 통해 더해주어야 하지만, kotlin에서는 ${}를 통해 출력해줄 수 있다.
    // 내부 중괄호를 생략할 수 있으나, 멤버변수나 메서드를 사용하는 경우는 붙여주어야 함
    // 생략하지 않는 것이 권장

    val person = Person("안녕")
    // ㅋㅋㅋ 내 이름은 안녕
    println("ㅋㅋㅋ 내 이름은 ${person.name}")
    // ㅋㅋㅋ 내 이름은 강좌정리.코틀린입문.codes.section2.Person@49e4cb85.name
    println("ㅋㅋㅋ 내 이름은 $person.name ")

    val name = "얼쑤"
    println("자 이제 봅시다 $name")

    val sb = """
        여기에 자유롭게 
        string을 작성할 수 있다.
        $name
    """.trimIndent()
    println(sb)

    // charAt -> 파이썬처럼 배열 index로 가져올 수 있다.
    val str = "abcde"
    println(str[0])
    println(str[3])
}