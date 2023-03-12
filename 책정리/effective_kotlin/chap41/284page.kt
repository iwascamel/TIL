package 책정리.effective_kotlin.chap41

data class FullName(
    var name: String,
    var surname: String
)

fun main(){
    val person = FullName("A","B")
    val mutableSet = mutableSetOf<FullName>()

    mutableSet.add(person)
    println(person.hashCode())
    person.surname = "C"

    println(person)
    println(person.hashCode())
    println(person in mutableSet)
    println(mutableSet.first() == person)
}