package br.thomas.application.ports.in;

import java.util.List;
import java.util.Optional;

import br.thomas.domain.Task;

public interface TaskUseCases {
    Task addTask(Task task);
    Optional<Task> getTaskById(Long id);
    List<Task> getAllTasks();
    Task updateTask(Long id, Task taskDetails);
    Task deleteTask(Long id);
}
