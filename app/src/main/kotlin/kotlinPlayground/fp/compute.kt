package kotlinPlayground.fp

fun main() {
    // 람다식
    compute(1, 1) { a, b -> a + b }

    // 익명 함수
    compute(1, 1, fun(a, b) = a + b)
    compute(1, 1, fun(a, b): Int {
        return a + b
    })
}

fun compute(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}
