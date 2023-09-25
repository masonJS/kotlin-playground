package kotlinPlayground.overLoadingDsl

fun main() {
    var point = Point(10, 20)

    println(-point)
    println(++point)
    println(point + Point(10, 10))
}

data class Point(
    val x: Int,
    val y: Int,
) {
    operator fun unaryMinus() = Point(-x, -y)

    operator fun inc() = Point(x + 1, y + 1)

    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
}
