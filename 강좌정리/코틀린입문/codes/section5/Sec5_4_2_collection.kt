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

    val map: Map<String,List<Fruit>> = fruits.groupBy { it.name }
    // associateBy
    // 중복되지 않는 키를 갖고 map을 사용할 때 사용한다.
    // val map: Map<Long,Fruit> = fruits.associateBy{fruit -> fruit.id}
}