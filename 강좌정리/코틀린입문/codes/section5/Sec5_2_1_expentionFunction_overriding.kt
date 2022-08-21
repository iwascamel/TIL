package 강좌정리.코틀린입문.codes.section5

fun main(){
    val train: Train = Train()
    train.a()

    // train의 확장함수가 호출된다.
    // 즉, 정적인 타입(현재타입)에 의해 어떤 함수가 호출될 지 결정된다.
    val srt1 : Train = Srt()
    srt1.a()

    val srt2: Srt = Srt()
    srt2.a()
}

open class Train(
    val name: String = "name1",
    val price: Int = 5000,
)

fun Train.a(){
    println("train a")
    println(this.price)
}

class Srt: Train("SRT",40000)

fun Srt.a(){
    println("srt a")
    println(this.price)
}
