package br.thomas.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.thomas.application.ports.out.TaskRepositoryPort;
import br.thomas.domain.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TaskRepository implements TaskRepositoryPort {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            entityManager.persist(task);
        } else {
            entityManager.merge(task);
        }
        return task;
    }

    @Override
    public Optional<Task> findById(Long id) {
        Task task = entityManager.find(Task.class, id);
        return Optional.ofNullable(task);
    }

    @Override
    public List<Task> findAll() {
        return entityManager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }

    @Override
    public void delete(Task task) {
        if (entityManager.contains(task)) {
            entityManager.remove(task);
        } else {
            Task attachedTask = entityManager.find(Task.class, task.getId());
            if (attachedTask != null) {
                entityManager.remove(attachedTask);
            }
        }
    }

    @Override
    public boolean existsById(Long id) {
        Task task = entityManager.find(Task.class, id);
        return task != null;
    }
}
