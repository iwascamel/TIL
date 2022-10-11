package 책정리.다재다능코틀린프로그래밍.codes.chap8

class TvV2{
    private var volume=0
    // iterator() 메서드가 새로운 생성자를 반환하는 것과 유사하게 동작한다.
    val remote: Remote
        get() = TvRemoteV2()
    override fun toString(): String = "[callTvV2 toString]volume : $volume"
    inner class TvRemoteV2: Remote{
        override fun up() {
            volume++
        }

        override fun down() {
            volume--
        }
        // ${this@TvV2} = TvV2의 toString()이 호출된다.
        override fun toString() = "[callTvRemoteV2 toString]Remote: ${this@TvV2}"
    }
}

class TvV3{
    private var volume=0
    val remote: Remote
        // 익명 클래스로 생성
        get() = object : Remote{
        override fun up() {
            volume++
        }

        override fun down() {
            volume--
        }
        override fun toString() = "[callTvRemoteV2 toString]Remote: ${this@TvV3}"
    }
}

fun main(){
    val tv2num1 = TvV2()
    val remoteV1 = tv2num1.remote
    val tv2num2 = TvV2()
    val remoteV2 = tv2num2.remote

    // 당연하지만, 두 hashCode()는 다르다.
    println(remoteV1.hashCode())
    println(remoteV2.hashCode())

    println("TvV2의 toString = $tv2num1")
    println("remoteV1의 toString = $remoteV1")
}