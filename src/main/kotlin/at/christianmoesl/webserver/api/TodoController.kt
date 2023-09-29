package at.christianmoesl.webserver.api;

import at.christianmoesl.webserver.todo.TodoService
import jakarta.validation.Valid
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/todos")
class TodoController(
    private val todoService: TodoService,
    private val mapper: TodoMapper
) {
    private val log = LoggerFactory.getLogger(TodoController::class.java)

    @GetMapping
    suspend fun listAllTodos(): Flow<TodoDto> = todoService.getAllUndoneTodos()
        .mapNotNull { mapper.map(it) }

    @GetMapping("/{id}")
    suspend fun getTodo(@PathVariable id: Long): TodoDto? {
        log.info("Received request for a todo with id $id.")

        return todoService.getById(id)?.let { mapper.map(it) }
    }

    @PostMapping
    suspend fun createTodo(@RequestBody @Valid input: TodoInputDto): TodoDto {
        log.info("Received create request for todo.")

        val todo = todoService.create(mapper.map(input))

        return mapper.map(todo)
    }

    @PatchMapping("/{id}")
    suspend fun updateTodo(@PathVariable id: Long, @RequestBody @Valid update: TodoUpdateDto): TodoDto {
        log.info("Received update request for todo with id {}.", id)

        val todo = todoService.getById(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Todo with id $id not found.")

        return mapper.map(todoService.update(todo))
    }
}
