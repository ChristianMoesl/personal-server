package at.christianmoesl.webserver.todo

import org.springframework.data.annotation.Id
import java.time.Instant

data class Todo(
    @Id
    val id: Int?,
    val text: String,
    val isDone: Boolean,
    val createdAt: Instant
)