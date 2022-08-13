package 강좌정리.코틀린입문.codes.section2

fun main(){
    printNameIfPersonV3(Person("안녕"))
    printNameIfPersonV3(null)
}

fun printNameIfPerson(obj: Any){
    // java: obj instance of Person
    if (obj is Person){
        // obj 를 Person 타입으로 간주한다.
        // smartCast
        // 이미 if안에 들어갔으므로, as Person은 생략가능하다.
        val person = obj as Person
        println(person.name)
    }
}

fun printNameIfPersonV2(obj: Any){
    // !is -> not
    if (obj !is Person){
    }
}

fun printNameIfPersonV3(obj: Any?){
    // null이 아니라면 Person으로 변환
    // null이라면 전체가 null로 변환
    // 즉, Person? 타입인 것
    // 원래 as 는 type이 아니면 에러가 뜨지만, as? 를 쓰면 에러가 아니라 safe call처럼 null이 반환된다.
    val person = obj as? Person
    println(person?.name ?: "이름이 없음")
}