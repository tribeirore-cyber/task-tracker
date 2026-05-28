package br.thomas.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.thomas.model.Task;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return task;
    }
}