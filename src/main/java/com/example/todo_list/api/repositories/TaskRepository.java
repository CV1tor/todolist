package com.example.todo_list.api.repositories;

import com.example.todo_list.api.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    Optional<Task> findById(String id);

    List<Task> findAll();

    List<Task> findAllByCompleted(Boolean completed);
}
