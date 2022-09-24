package 책정리.다재다능코틀린프로그래밍.codes.chap45

fun main(){
    // listOf
    val fruits: List<String> = listOf("Apple","Cherry","Grape")
    println("${fruits.get(0)} + ${fruits[0]}")

    // immutable list에 값을 더하려면?
    val fruits2 = fruits + "new Fruit!"
    println(fruits2)

    // set
    val setFruits = setOf("Apple","Cherry","Grape")

    // map
    val mapFruits = mapOf("Apple" to 1,"Cherry" to 2)

    // mutable map
    val mutableMapFruits = mutableMapOf<String,Int>()

    // map.put("apple") -> map["apple"]
    mutableMapFruits["Apple"] = 1
    println(mapFruits.getOrDefault("Appleee","그거없다!"))

    // mutable map에 값을 추가하려면?
    val newMapFruits = mapFruits + ("plus" to 4)
    println(newMapFruits)

    // map 구조분해
    for((key,value) in newMapFruits){
        println("$key = $value")
    }
}