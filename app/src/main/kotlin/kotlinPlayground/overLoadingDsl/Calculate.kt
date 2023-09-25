package kotlinPlayground.overLoadingDsl

fun main() {
    println(Operator.PLUS(1, 2))
    println(Operator.MINUS(1, 2))
    println(Operator.MULTIPLY(1, 2))
    println(Operator.DIVIDE(1, 2))
    println(Operator.REMAINDER(1, 2))
}

enum class Operator(private val operator: Char, val calcFun: (Int, Int) -> Int) {
    PLUS('+', { a, b -> a + b }),
    MINUS('-', { a, b -> a - b }),
    MULTIPLY('*', { a, b -> a * b }),
    DIVIDE('/', { a, b ->
        if (b == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
        a / b
    }),
    REMAINDER('%', { a, b ->
        if (b == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
        a % b
    }),
    ;

    operator fun invoke(num1: Int, num2: Int) = calcFun(num1, num2)
}
