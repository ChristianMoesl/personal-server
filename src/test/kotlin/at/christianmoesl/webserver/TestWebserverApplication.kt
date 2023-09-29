package at.christianmoesl.webserver

import org.springframework.boot.fromApplication

fun main(args: Array<String>) {
    fromApplication<WebserverApplication>()
        .with(TestcontainerConfiguration::class.java)
        .run(*args);
}

