package at2.oslina.dbvalid.service;

import at2.oslina.dbvalid.dto.TodoDto;
import at2.oslina.dbvalid.model.Event;
import at2.oslina.dbvalid.model.TodoList;
import at2.oslina.dbvalid.repository.TodoRepos;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class TodoService {
    private final TodoRepos todoRepos;

    public Set<TodoDto> getAll() {
        Set<TodoList> todoLists = todoRepos.findAll();
        return todoLists.stream().map(TodoDto::new).collect(Collectors.toSet());
    }

    public void addTodo(TodoDto todoList) {
        TodoList todo = new TodoList();
        todo.setName(todoList.getName());
        Set<Event> events = todoList.getEvents().stream()
                .map(x -> new Event(x, todo)).collect(Collectors.toSet());
        todo.setEvents(events);
        todoRepos.save(todo);
    }

    public TodoList getTodo(Long id) {
        return todoRepos.getTodoListById(id);
    }
}
