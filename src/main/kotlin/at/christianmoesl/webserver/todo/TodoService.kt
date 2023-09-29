package at.christianmoesl.webserver.todo

import org.springframework.stereotype.Service
import org.springframework.util.Assert

@Service
class TodoService(private val todoRepository: TodoRepository) {

    suspend fun getAllUndoneTodos() = todoRepository.findTodosByIsDoneIsFalse()

    suspend fun getById(todoId: Long) = todoRepository.findById(todoId)

    suspend fun create(todo: Todo): Todo {
        Assert.isNull(todo.id, "ID hast to be null when creating an todo entity.")

        return todoRepository.save(todo)
    }

    suspend fun update(todo: Todo): Todo {
        Assert.notNull(todo.id, "ID has to be not null when updating an todo.")

        return todoRepository.save(todo)
    }
}