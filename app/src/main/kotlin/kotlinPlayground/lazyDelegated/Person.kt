package kotlinPlayground.lazyDelegated

class Person {
    lateinit var name: String

    val isKim: Boolean
        get() = this.name.startsWith('김')

    val makingName: String
        get() = name[0] + (1 until name.length).map { '*' }.joinToString("")

    val firstName by lazy {
        Thread.sleep(2_000)
        name.split(" ")[0]
    }
}

fun main() {
    val person = Person()
    person.name = "김철수"
    println(person.isKim)
    println(person.makingName)
    println(person.firstName)
}
