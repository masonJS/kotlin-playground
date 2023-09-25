package kotlinPlayground.overLoadingDsl.dsl

val yml = dockerCompose {
    version { 3 }
    service(name = "db") {
        image { "posgresql" }
        env("USER" - "myUser")
        env("PASSWORD" - "myPassword")
        port(host = 5432, container = 999)
//        service(name = "db") {
//            image { "posgresql" }
//            env("USER" - "myUser")
//            env("PASSWORD" - "myPassword")
//            port(host = 5432, container = 999)
//        }
    }
}

fun dockerCompose(init: DockerCompose.() -> Unit): DockerCompose {
    val dockerCompose = DockerCompose()
    dockerCompose.init()
    return dockerCompose
}

class DockerCompose {
    private var version: Int by onceNotNull()
    private val services = mutableListOf<Service>()

    fun version(init: () -> Int) {
        version = init()
    }

    fun service(name: String, init: Service.() -> Unit) {
        val service = Service(name)
        service.init()
        services.add(service)
    }
}
