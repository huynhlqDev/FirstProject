package huynhlq.dev.udemy.firstproject.service;

import huynhlq.dev.udemy.firstproject.model.entity.Task;
import java.util.List;

public interface TaskService {
    List<Task> getAll();
    Task create(Task task);
    Task update(Task task);
    boolean delete(long id);
    boolean existsById(Long id);
}
