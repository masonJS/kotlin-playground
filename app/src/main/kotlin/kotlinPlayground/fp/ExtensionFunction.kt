package kotlinPlayground.fp

val add = fun Int.(other: Long): Int = this + other.toInt()

fun main() {
    add.invoke(1, 2L)
    add(1, 2L)
    1.add(2L)
}
