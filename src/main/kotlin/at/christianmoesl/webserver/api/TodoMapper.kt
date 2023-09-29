package at.christianmoesl.webserver.api

import at.christianmoesl.webserver.todo.Todo
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface TodoMapper {
    fun map(todo: Todo): TodoDto

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isDone", expression = "java(true)")
    @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
    fun map(input: TodoInputDto): Todo
}