package com.example.todo_list.api.controllers;

import com.example.todo_list.api.domain.task.Task;
import com.example.todo_list.api.dto.TaskDTO;
import com.example.todo_list.api.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getCompletedTasks() {
        List<Task> tasks = taskService.getCompletedTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/uncompleted")
    public ResponseEntity<List<Task>> getUncompletedTasks() {
        List<Task> tasks = taskService.getNotCompletedTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody TaskDTO task) {
        taskService.createTask(task);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) throws Exception {
        taskService.deleteTask(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/complete/{id}")
    public ResponseEntity<Void> completeTask(@PathVariable String id) throws Exception {
        taskService.completeTask(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
