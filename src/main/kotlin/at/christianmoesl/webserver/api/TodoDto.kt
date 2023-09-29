package at.christianmoesl.webserver.api

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class TodoDto(val id: Long, val text: String)

data class TodoInputDto(@field:NotBlank val text: String?)

data class TodoUpdateDto(@field:NotNull val isDone: Boolean?)
