package 강좌정리.코틀린입문.codes.section5

fun main(){
    val fruits = listOf(
        Fruit("사과",1000),
        Fruit("사과",1200),
        Fruit("사과",1200),
        Fruit("사과",1500),
        Fruit("바나나",3000),
        Fruit("바나나",3200),
        Fruit("수박",10000),
        )

    // 함수에 이름이 없다. => lamba
    val isApple = fun(fruit: Fruit) : Boolean{
        return fruit.name == "사과"
    }

    // 타입 명시
    val isAppleV2: (Fruit) -> Boolean = fun(fruit: Fruit) : Boolean{
        return fruit.name == "사과"
    }

    // 더 많이 사용
    val isApple2 = {frut: Fruit -> frut.name == "사과"}

    isApple(fruits[0])
    // 명시적으로 invoke를 사용해서 호출할 수도 있다.
    isApple.invoke(fruits[0])

    filterFruits(fruits,isApple)

    // 함수에서 받는 함수의 parameter가 마지막에 위치할 경우 괄호 밖으로 뺄 수 있다.
    // 이때, Fruit은 추론 가능하므로 생략가능
    filterFruits(fruits){frut: Fruit -> frut.name == "사과"}

    // parameter가 1개인 경우 it을 사용하면 it이 해당 parameter가 된다.
    filterFruits(fruits){it.name == "사과"}

    // 람다를 여러 줄 작성할 수도 있도, 마지막 줄의 결과가 lambda의 반환값이다.
    filterFruits(fruits){
        println("a")
        println("b")
        it.name == "사과"}
}

private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
) :List<Fruit>{
    val results = mutableListOf<Fruit>()

    for(fruit in fruits){
        if(filter(fruit)){
            results.add(fruit)
        }
    }
    return results
}

class Fruit(
    val name: String,
    val price: Int
)