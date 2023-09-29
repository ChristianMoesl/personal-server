package at.christianmoesl.webserver

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@SpringBootTest
@Import(TestcontainerConfiguration::class)
class WebserverApplicationTests {

    @Test
    fun contextLoads() {
    }

}
