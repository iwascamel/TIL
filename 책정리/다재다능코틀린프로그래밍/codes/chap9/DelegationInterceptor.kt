package 책정리.다재다능코틀린프로그래밍.codes.chap9

import kotlin.reflect.KProperty

fun main(){
    var stupidWord: String by beingPolite("init value")
    println(stupidWord)
    stupidWord = "stupid"
    println(stupidWord)
}

class PoliteString(var content:String){
    operator fun getValue(thisRef:Any?, property: KProperty<*>) =
        content.replace("stupid","s******")

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value:String){
        content = value
    }
}

fun beingPolite(content: String) = PoliteString(content)