package 책정리.다재다능코틀린프로그래밍.codes.chap6

fun main(){
    copyFromToTest1()
    copyFromToTest2()
}

fun copyFromToTest1(){
    val fruitBasket1 = Array<Fruit>(3) { Fruit()}
    val fruitBasket2 = Array<Fruit>(3) { Fruit()}
    copyFromTo(fruitBasket1,fruitBasket2)
}

fun copyFromToTest2(){
    val fruitBasket1 = Array<Fruit>(3) { Fruit()}
    val fruitBasket2 = Array<Fruit.Cherry>(3) { Fruit.Cherry()}
//    copyFromTo(fruitBasket1,fruitBasket2)
}

fun copyFromToTest3(){
    val fruitBasket1 = Array<Fruit>(3) { Fruit()}
    val fruitBasket2 = Array<Any>(3) { Fruit.Cherry()}
    copyFromToV2(fruitBasket1,fruitBasket2)
}

fun copyFromTo(from: Array<Fruit>, to: Array<Fruit>){
    for(i in from.indices){
        to[i] = from[i]
    }
}

fun copyFromToV2(from: Array<out Fruit>, to: Array<in Fruit>){
    for(i in from.indices){
        to[i] = from[i]
    }
}

open class Fruit{
    class Cherry: Fruit()
    class Orange: Fruit()
}