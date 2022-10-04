package 책정리.다재다능코틀린프로그래밍.codes.chap7

fun main(){
    Factory.create()
}

class Factory private constructor(name:String){
    companion object{
        fun create(): Factory {
            return Factory("테스트")
        }
    }
}