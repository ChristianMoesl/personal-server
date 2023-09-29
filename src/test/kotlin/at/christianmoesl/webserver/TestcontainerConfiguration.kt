package at.christianmoesl.webserver

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.containers.PostgreSQLR2DBCDatabaseContainer

@TestConfiguration(proxyBeanMethods = false)
class TestcontainerConfiguration {
    @Bean
    @ServiceConnection
    fun postgresqlContainer() = PostgreSQLR2DBCDatabaseContainer(PostgreSQLContainer("postgres:16"))
}