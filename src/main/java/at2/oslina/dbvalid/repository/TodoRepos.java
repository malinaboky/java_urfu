package at2.oslina.dbvalid.repository;

import at2.oslina.dbvalid.model.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TodoRepos extends CrudRepository<TodoList, Long> {
    Set<TodoList> findAll();
    TodoList getTodoListById(Long id);
}
