package at2.oslina.dbvalid.dto;

import at2.oslina.dbvalid.model.Event;
import at2.oslina.dbvalid.model.TodoList;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class TodoDto {
    private String name;
    private Set<String> events;

    public TodoDto(TodoList todoList) {
        this.name = todoList.getName();
        this.events = todoList.getEvents().stream().map(Event::getName).collect(Collectors.toSet());
    }
}
