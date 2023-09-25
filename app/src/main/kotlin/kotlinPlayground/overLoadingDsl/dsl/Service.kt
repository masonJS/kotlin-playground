package kotlinPlayground.overLoadingDsl.dsl

class Service(val name: String) {
    private var image: String by onceNotNull()
    private var environments = mutableListOf<Environment>()
    private var portRules = mutableListOf<PortRules>()

    fun image(init: () -> String) {
        image = init()
    }

    fun env(environment: Environment) {
        environments.add(environment)
    }

    fun port(host: Int, container: Int) {
        portRules.add(PortRules(host, container))
    }
}

data class Environment(
    val key: String,
    val value: String,
)

operator fun String.minus(value: String): Environment {
    return Environment(this, value)
}

data class PortRules(
    val host: Int,
    val container: Int,
)
