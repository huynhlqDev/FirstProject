package huynhlq.dev.udemy.firstproject.apiAction;

import huynhlq.dev.udemy.firstproject.common.Logger;
import huynhlq.dev.udemy.firstproject.model.entity.Task;
import huynhlq.dev.udemy.firstproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskAction {
    private final TaskService taskService;

    public TaskAction(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        Logger.addActionLog("Retrieving all tasks");
        List<Task> projects = taskService.getAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Validated Task task, BindingResult result) {
        // Authentication

        // Request validation
        if (result.hasErrors()) {
            Logger.addErrorLog(result.getAllErrors());
            return new ResponseEntity<>(result.getAllErrors().get(0), HttpStatus.BAD_REQUEST);
        }

        // logic
        Logger.addActionLog("Creating task of" + task.getProjectSequense());
        Task createTask = taskService.create(task);
        if (createTask == null) {
            Logger.addErrorLog("Failed to create task of " + task.getProjectSequense());
            return new ResponseEntity<>("Failed to create task", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(createTask, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Validated Task task, BindingResult result) {
        // Authentication

        // Request validation
        if (result.hasErrors()) {
            Logger.addErrorLog(result.getAllErrors());
            return new ResponseEntity<>(result.getAllErrors().get(0), HttpStatus.BAD_REQUEST);
        }

        // logic
        Logger.addActionLog("Updating task" + task.getProjectSequense());
        Task updateTask = taskService.update(task);
        if (updateTask == null) {
            Logger.addErrorLog("Failed to updated task of " + task.getProjectSequense());
            return new ResponseEntity<>("Failed to updated task", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(updateTask, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        // Authentication

        // logic
        Logger.addActionLog("Deleting task ID: " + id);
        boolean isDeleted = taskService.delete(id);
        if (isDeleted) {
            Logger.addActionLog("Deleted task ID: " + id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            Logger.addErrorLog("Failed to delete task ID: " + id);
            return new ResponseEntity<>("Failed to delete task ID: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
