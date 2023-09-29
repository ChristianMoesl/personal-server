package at.christianmoesl.webserver.todo;

import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : CoroutineCrudRepository<Todo, Long> {
    suspend fun findTodosByIsDoneIsFalse(): Flow<Todo>
}

