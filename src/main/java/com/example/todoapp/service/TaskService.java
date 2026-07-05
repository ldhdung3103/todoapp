package com.example.todoapp.service;
import com.example.todoapp.repository.TaskRepository;
import com.example.todoapp.entity.Task;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void toggleCompleted(long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found!"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }

    public void deleteById(long id) {
        taskRepository.deleteById(id);
    }
}
