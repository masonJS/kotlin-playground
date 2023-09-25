package kotlinPlayground.overLoadingDsl.dsl

val yml = dockerCompose {
    version { 3 }
    service(name = "db") {
        image { "posgresql" }
        env("USER" - "myUser")
        env("PASSWORD" - "myPassword")
        port(host = 5432, container = 999)
        // YamlDsl 어노테이션으로 인해 오류 발생
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

@YamlDsl
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
