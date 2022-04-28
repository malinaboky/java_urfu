package at2.oslina.dbvalid.controller;

import at2.oslina.dbvalid.dto.TodoDto;
import at2.oslina.dbvalid.model.TodoList;
import at2.oslina.dbvalid.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Set;

@Validated
@RestController
@AllArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/todo")
    public void addTodoList(@Valid @RequestBody TodoDto todoList) {
        todoService.addTodo(todoList);
    }

    @GetMapping("/todo")
    public Set<TodoDto> getTodos() {
        return todoService.getAll();
    }

    @GetMapping("/todo/{id}")
    public TodoList getTodo(@PathVariable @Min(1) Long id) {
        return todoService.getTodo(id);
    }
 }
