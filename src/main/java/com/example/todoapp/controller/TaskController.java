package com.example.todoapp.controller;
import com.example.todoapp.entity.Task;
import com.example.todoapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(@RequestParam(required = false) String status, Model model) {
        if ("active".equals(status)) {
            model.addAttribute("tasks", taskService.findAllByCompleted(false));
        } else if ("completed".equals(status)) {
            model.addAttribute("tasks", taskService.findAllByCompleted(true));
        } else {
            model.addAttribute("tasks", taskService.findAll());
        }

        model.addAttribute("task", new Task());
        model.addAttribute("status", status);
        return "index";
    }

    @PostMapping("/tasks")
    public String saveTask(@Valid @ModelAttribute("task") Task task, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("tasks", taskService.findAll());
            model.addAttribute("status", null);
            return "index";
        }
        taskService.save(task);
        return "redirect:/";
    }

    @PostMapping("/tasks/{id}/toggle")
    public String toggleTask(@PathVariable long id) {
        taskService.toggleCompleted(id);
        return "redirect:/";
    }

    @PostMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable long id) {
        taskService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/tasks/{id}/edit")
    public String editTask(@PathVariable long id, Model model) {
        Task task = taskService.findById(id);
        model.addAttribute("task", task);
        return "edit";
    }

    @PostMapping("/tasks/{id}/edit")
    public String updateTask(@PathVariable long id, @Valid @ModelAttribute("task") Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            task.setId(id);
            return "edit";
        }
        taskService.updateTask(id, task);
        return "redirect:/";
    }
}
