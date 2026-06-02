package br.thomas.application.ports.out;

import java.util.List;
import java.util.Optional;

import br.thomas.domain.Task;

public interface TaskRepositoryPort {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
    void delete(Task task);
    boolean existsById(Long id);
}
