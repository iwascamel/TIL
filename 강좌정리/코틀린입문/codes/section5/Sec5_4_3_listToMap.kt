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

    // key, value를 동시에 처리 가능
//    val map: Map<String,List<Long>> = fruits.groupBy({fruit -> fruit.name} , {fruit -> fruit.price })
}