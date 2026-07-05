package com.example.todoapp.controller;
import com.example.todoapp.entity.Task;
import com.example.todoapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("task", new Task());
        return "index";
    }

    @PostMapping("/tasks")
    public String saveTask(@ModelAttribute Task task) {
        System.out.println("Title = " + task.getTitle());
        System.out.println("Description = " + task.getDescription());
        taskService.save(task);
        return "redirect:/";
    }

    @PostMapping("/tasks/{id}/toggle")
    public String toggleTask(@PathVariable long id) {
        taskService.toggleCompleted(id);
        return "redirect:/";
    }
}
