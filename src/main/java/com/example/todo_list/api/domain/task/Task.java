package com.example.todo_list.api.domain.task;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="task")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    public String id;

    public String title;

    public Boolean completed = Boolean.FALSE;
}
