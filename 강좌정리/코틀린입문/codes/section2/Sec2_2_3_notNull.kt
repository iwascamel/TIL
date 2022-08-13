fun main(){

}

// !! -> null이 아니다.
// 만약 null이 들어오면 런타임에 npe가 터진다.
fun startsWithNotNull(str: String?) : Boolean{
    return str!!.startsWith("a")
}