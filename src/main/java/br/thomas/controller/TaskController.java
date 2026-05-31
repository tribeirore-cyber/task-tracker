package br.thomas.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import br.thomas.model.Task;
import br.thomas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private TaskRepository repository;

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task response = repository.save(task);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Task>> listTasks() {
        List<Task> tasks = repository.findAll();
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task taskDetails) {
        Optional<Task> existingTaskOptional = repository.findById(id);
        if (existingTaskOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Task existingTask = existingTaskOptional.get();
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setStatus(taskDetails.getStatus());
        existingTask.setUpdatedAt(LocalDateTime.now());
        Task updatedTask = repository.save(existingTask);
        return ResponseEntity.ok(updatedTask);
    }
}