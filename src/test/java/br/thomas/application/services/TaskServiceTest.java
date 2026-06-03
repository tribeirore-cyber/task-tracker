package br.thomas.application.services;

import br.thomas.application.ports.out.TaskRepositoryPort;
import br.thomas.domain.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepositoryPort taskRepositoryPort;

    @InjectMocks
    private TaskService taskService;

    private Task task1;
    private Task task2;

    @BeforeEach
    void setUp() {
        task1 = new Task("Test Task 1");
        task1.setId(1);
        task1.setCreatedAt(LocalDateTime.now());
        task1.setUpdatedAt(LocalDateTime.now());
        task1.setStatus("todo");

        task2 = new Task("Test Task 2");
        task2.setId(2);
        task2.setCreatedAt(LocalDateTime.now());
        task2.setUpdatedAt(LocalDateTime.now());
        task2.setStatus("in-progress");
    }

    @Test
    void addTask_shouldSaveAndReturnTask() {
        Task newTask = new Task("New Task");
        when(taskRepositoryPort.save(any(Task.class))).thenReturn(newTask);
        Task savedTask = taskService.addTask(newTask);
        assertNotNull(savedTask);
        assertEquals(newTask.getDescription(), savedTask.getDescription());
        verify(taskRepositoryPort, times(1)).save(newTask);
    }

    @Test
    void getTaskById_shouldReturnTask_whenExists() {
        when(taskRepositoryPort.findById(1L)).thenReturn(Optional.of(task1));
        Optional<Task> foundTask = taskService.getTaskById(1L);
        assertTrue(foundTask.isPresent());
        assertEquals(task1.getId(), foundTask.get().getId());
        verify(taskRepositoryPort, times(1)).findById(1L);
    }

    @Test
    void getTaskById_shouldReturnEmptyOptional_whenNotExists() {
        when(taskRepositoryPort.findById(99L)).thenReturn(Optional.empty());
        Optional<Task> foundTask = taskService.getTaskById(99L);
        assertFalse(foundTask.isPresent());
        verify(taskRepositoryPort, times(1)).findById(99L);
    }

    @Test
    void getAllTasks_shouldReturnListOfTasks() {
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        when(taskRepositoryPort.findAll()).thenReturn(taskList);
        List<Task> allTasks = taskService.getAllTasks();
        assertNotNull(allTasks);
        assertEquals(2, allTasks.size());
        verify(taskRepositoryPort, times(1)).findAll();
    }

    @Test
    void updateTask_shouldUpdateAndReturnTask_whenExists() {
        Task updatedDetails = new Task("Updated Task 1 Description");
        updatedDetails.setStatus("completed");
        Task expectedTask = new Task(updatedDetails.getDescription());
        expectedTask.setId(task1.getId());
        expectedTask.setCreatedAt(task1.getCreatedAt());
        expectedTask.setStatus(updatedDetails.getStatus());
        expectedTask.setUpdatedAt(LocalDateTime.now());
        when(taskRepositoryPort.findById(1L)).thenReturn(Optional.of(task1));
        when(taskRepositoryPort.save(any(Task.class))).thenReturn(expectedTask);
        Task resultTask = taskService.updateTask(1L, updatedDetails);
        assertNotNull(resultTask);
        assertEquals(updatedDetails.getDescription(), resultTask.getDescription());
        assertEquals("completed", resultTask.getStatus());
        assertNotNull(resultTask.getUpdatedAt());
        verify(taskRepositoryPort, times(1)).findById(1L);
        verify(taskRepositoryPort, times(1)).save(any(Task.class));
    }

    @Test
    void updateTask_shouldReturnNull_whenNotExists() {
        Task taskDetails = new Task("Some Description");
        when(taskRepositoryPort.findById(99L)).thenReturn(Optional.empty());
        Task resultTask = taskService.updateTask(99L, taskDetails);
        assertNull(resultTask);
        verify(taskRepositoryPort, times(1)).findById(99L);
        verify(taskRepositoryPort, never()).save(any(Task.class));
    }

    @Test
    void deleteTask_shouldDeleteAndReturnTask_whenExists() {
        when(taskRepositoryPort.findById(1L)).thenReturn(Optional.of(task1));
        Task deletedTask = taskService.deleteTask(1L);
        assertNotNull(deletedTask);
        assertEquals(task1.getId(), deletedTask.getId());
        verify(taskRepositoryPort, times(1)).findById(1L);
        verify(taskRepositoryPort, times(1)).delete(task1);
    }

    @Test
    void deleteTask_shouldReturnNull_whenNotExists() {
        when(taskRepositoryPort.findById(99L)).thenReturn(Optional.empty());
        Task deletedTask = taskService.deleteTask(99L);
        assertNull(deletedTask);
        verify(taskRepositoryPort, times(1)).findById(99L);
        verify(taskRepositoryPort, never()).delete(any(Task.class));
    }
}
