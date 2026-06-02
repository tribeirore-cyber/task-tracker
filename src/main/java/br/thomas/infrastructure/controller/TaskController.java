package br.thomas.infrastructure.controller;

import java.util.List;

import br.thomas.application.ports.in.TaskUseCases;
import br.thomas.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskUseCases taskUseCases;

    @Autowired
    public TaskController(TaskUseCases taskUseCases) {
        this.taskUseCases = taskUseCases;
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task response = taskUseCases.addTask(task);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Task>> listTasks() {
        List<Task> tasks = taskUseCases.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") long id, @RequestBody Task taskDetails) {
        Task updatedTask = taskUseCases.updateTask(id, taskDetails);
        if (updatedTask == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable("id") long id) {
        Task deletedTask = taskUseCases.deleteTask(id);
        if (deletedTask == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletedTask);
    }
}
