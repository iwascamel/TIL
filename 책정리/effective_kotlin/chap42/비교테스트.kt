package 책정리.effective_kotlin.chap42

data class User(val name:String, val age:Int): Comparable<User>{
    override fun compareTo(other: User): Int {
        return compareValues(name,age)
        // 더 많은 비교 -> compareValuesBy
    }

}
fun main(){
    val listOfUser = listOf(User("hello1",1),User("hello2",5),User("hello3",3))
    val resultSortedBy = listOfUser.sortedBy { it.age }
    val resultSortedWith = listOfUser.sortedWith(compareBy({it.age}, {it.name}))
}