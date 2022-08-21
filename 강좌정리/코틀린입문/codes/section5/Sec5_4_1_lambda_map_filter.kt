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
    val apples = fruits.filter { it.name == "사과" }
    // 사과 인덱스 필요한 경우
    val apples2 = fruits.filterIndexed{ idx,frut ->
        println(idx)
        frut.name == "사과"
    }
    // map 사과의 가격 매핑
    val applePrices = fruits.filter { it.name == "사과" }
            .map { fruit -> fruit.price }
}

// 람다 함수를 그냥 넘겨주면 되므로, 아래처럼 깔끔하게 함수를 구성할 수 있다.
private fun filterFruits(
    fruits: List<Fruit> , filter: (Fruit) -> Boolean
): List<Fruit>{
    return fruits.filter(filter)
}