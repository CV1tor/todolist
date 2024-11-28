package com.example.todo_list.api.services;

import com.example.todo_list.api.domain.task.Task;
import com.example.todo_list.api.dto.TaskDTO;
import com.example.todo_list.api.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getCompletedTasks() {
        return taskRepository.findAllByCompleted(Boolean.TRUE);
    }

    public List<Task> getNotCompletedTasks() {
        return taskRepository.findAllByCompleted(Boolean.FALSE);
    }

    public void createTask(TaskDTO task) {
        Task newTask = new Task();
        newTask.title = task.title();

        taskRepository.save(newTask);
    }

    public void deleteTask(String id) throws Exception {
        Task deletedTask = this.findTaskById(id);

        taskRepository.delete(deletedTask);
    }

    public void completeTask(String id) throws Exception {
        Task completedTask = this.findTaskById(id);
        if(completedTask.completed) {
            throw new Exception("Task already completed");
        }

        completedTask.completed = true;
        taskRepository.save(completedTask);
    }

    private Task findTaskById(String id) throws Exception {
        return taskRepository.findById(id).orElseThrow(() -> new Exception("Task not found."));
    }
}
