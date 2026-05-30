package br.thomas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.thomas.model.Task;
import br.thomas.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return repository.save(task);
    }

    @GetMapping(path = "/list")
    public List<Task> listTasks() {
        return repository.findAll();
    }
}