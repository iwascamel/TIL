package 책정리.effective_kotlin.chap36

class HashSetImplTest {
}

fun main(){
    val cs = CounterSet<Int>()
    cs.addAll(listOf(1,2,3))

    println(cs)
    println(cs.elementsAdded)
}

class CounterSet<T>: HashSet<T>() {
    var elementsAdded: Int = 0
        private set

    override fun add(element: T): Boolean {
        elementsAdded++
        return super.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        elementsAdded += elements.size
        return super.addAll(elements)
    }
}