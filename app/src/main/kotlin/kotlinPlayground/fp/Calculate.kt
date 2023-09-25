package kotlinPlayground.fp

fun calculate(num1: Int, num2: Int, operator: Operator) = operator.calcFun(num1, num2)

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
}
