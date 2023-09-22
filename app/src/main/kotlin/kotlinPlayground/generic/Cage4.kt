package kotlinPlayground.generic


fun main() {
    val cage = Cage4(mutableListOf(Sparrow(), Eagle()))

    cage.printAfterSorting()
}

class Cage4<T> (
    private val animals: MutableList<T> = mutableListOf()
) where T : Animal, T : Comparable<T> {
    fun printAfterSorting() {
        return animals.sorted().map { it.name }.let (::println)
    }

}

abstract class Bird(
    name: String,
    private val size: Int
) : Animal(name), Comparable<Bird> {
    override fun compareTo(other: Bird): Int {
        return this.size.compareTo(other.size)
    }
}

class Sparrow : Bird("참새", 100)
class Eagle : Bird("독수리", 500)