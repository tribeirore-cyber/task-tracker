package br.thomas.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.thomas.application.ports.in.TaskUseCases;
import br.thomas.application.ports.out.TaskRepositoryPort;
import br.thomas.domain.Task;
import jakarta.transaction.Transactional;

@Service
public class TaskService implements TaskUseCases {

    private final TaskRepositoryPort taskRepositoryPort;

    @Autowired
    public TaskService(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Transactional
    @Override
    public Task addTask(Task task) {
        return taskRepositoryPort.save(task);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }

    @Transactional
    @Override
    public Task updateTask(Long id, Task taskDetails) {
        Optional<Task> existingTaskOptional = taskRepositoryPort.findById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setDescription(taskDetails.getDescription());
            existingTask.setStatus(taskDetails.getStatus());
            existingTask.setUpdatedAt(java.time.LocalDateTime.now());
            return taskRepositoryPort.save(existingTask);
        }
        return null;
    }

    @Transactional
    @Override
    public Task deleteTask(Long id) {
        Optional<Task> taskOptional = taskRepositoryPort.findById(id);
        if (taskOptional.isPresent()) {
            Task taskToRemove = taskOptional.get();
            taskRepositoryPort.delete(taskToRemove);
            return taskToRemove;
        }
        return null;
    }
}
