package huynhlq.dev.udemy.firstproject.service.impl;

import huynhlq.dev.udemy.firstproject.model.entity.Task;
import huynhlq.dev.udemy.firstproject.repository.TaskRepository;
import huynhlq.dev.udemy.firstproject.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.getAll();
    }

    @Override
    public Task create(Task task) {
        if (existsById(task.getId())) {
            return null;
        }
        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        if (existsById(task.getId())) {
            return taskRepository.save(task);
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        Task taskNeed = taskRepository.findById(id).orElse(null);
        if (taskNeed != null) {
            taskNeed.setDeleted(true);
            taskRepository.save(taskNeed);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existsById(Long id) {
        return taskRepository.existsById(id);
    }
}
