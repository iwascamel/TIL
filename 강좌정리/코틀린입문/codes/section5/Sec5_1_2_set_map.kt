package 강좌정리.코틀린입문.codes.section5

fun main(){
    val numbers = setOf(100,200)

    for(number in numbers){
        println(number)
    }

    // 내부적으로 linkedHashSet을 사용
    val numbers2 = mutableSetOf(100,200,300)
    numbers2.add(500)

    for(number in numbers2){
        println(number)
    }

    val oldMap = mutableMapOf<Int,String>()
    oldMap.put(1,"money")
    oldMap[2] = "tuesday"
    println(oldMap)
    val mapOf = mapOf(1 to "money", 2 to "tuesday")
    println(mapOf)

    for(key in oldMap.keys){
        println(oldMap.get(key))
        println(oldMap[key])
    }

    for((key,value) in oldMap.entries){
        println("$key $value")
    }
}