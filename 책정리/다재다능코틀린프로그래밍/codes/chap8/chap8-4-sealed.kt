package 책정리.다재다능코틀린프로그래밍.codes.chap8

sealed class Card(val suit:String)
class Ace(suit: String): Card(suit)
open class King(suit: String): Card(suit){
    override fun toString(): String {
        return "King"
    }
    // == override fun toString() = "King"
}

class Prince(suit: String) : King(suit){
    override fun toString(): String {
        return "Prince"
    }
}

fun main(){
    val process = process(Prince("pr"))
    println(process)
}

// 들어올 수 있는 것은 king이나 ace타입 뿐이다.
fun process(card: Card) = when(card){
    is Ace -> "ace type ${card.javaClass.name} + ${card.suit}"
    is King -> "king type ${card.javaClass.name} + ${card.suit}"
}