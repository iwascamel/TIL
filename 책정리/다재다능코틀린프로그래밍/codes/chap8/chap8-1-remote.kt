package 책정리.다재다능코틀린프로그래밍.codes.chap8

interface Remote{
    fun up()
    fun down()
    // 구현하지 않아도 상관없고, override가 필요한 경우에만 override 하면 된다.
    // 즉, default 메서드처럼 작동한다.
    fun doubleUp(){
        up()
        up()
    }

    // static처럼 작동하는 companion object
    // Remote.combine() 으로 사용할 수 있다.
    companion object{
        fun combine(first: Remote, second: Remote) : Remote = object: Remote{
            // 내부에서도 override를 선언해주어야 한다.
            override fun up(){
                first.up()
                second.up()
            }
            override fun down(){
                first.down()
                second.down()
            }
        }
    }
}

class Tv{
    var volume = 0
}

class TvRemote(val tv: Tv): Remote{
    override fun up() {
        tv.volume++
    }

    override fun down() {
        tv.volume--
    }
}

fun main(){
    /*
    volume = 0
    after up = 1
    after doubleup = 3
    combine method operate = 5
     */
    val tv = Tv()
    val remote: Remote = TvRemote(tv)
    val secondRemote: Remote = TvRemote(tv)
    println("volume = ${tv.volume}")
    remote.up()
    println("after up = ${tv.volume}")
    remote.doubleUp()
    println("after doubleup = ${tv.volume}")

    val combine = Remote.combine(remote, secondRemote)
    combine.up()

    println("combine method operate = ${tv.volume}")
}