package hook_files


fun main(){
    val strings = listOf("foo","foo", "bar", "baz")
    val map = strings.associate { it.chars() to it.length }

    println(map)
    println(strings.associateBy { it })
}

class AssociateTest {
}