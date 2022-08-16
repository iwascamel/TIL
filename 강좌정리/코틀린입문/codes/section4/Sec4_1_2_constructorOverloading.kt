package 강좌정리.코틀린입문.codes.section4

// 기본이 public
// constructor 생략 가능
//class Sec4_1_1 constructor(name:String, age: Int){
//    val name = name
//    val age = age
//}

class Sec4_1_1 (val name:String, var age:Int){
    init{
        println("초기 생성자")
        if(age<=0){
            throw IllegalArgumentException("나이는 $age 일 수 없습니다")
        }
    }
    constructor(name:String): this(name,1){
        println("첫번째 부 생성자")
    }
    // 최종적으로 주 생성자를 호출하니까 가능
    constructor(): this("ersu"){
        println("두번째 부 생성자")
    }
}

fun main(){
    val person = Sec4_1_1()
}