package com.example.task.Repository;

import com.example.task.model.Task;

import java.util.List;
import java.util.UUID;

public interface Repository {
    List<Task> getTask();
    Task getTask(UUID uuid);
    void updateTask(Task task);
    void deleteTask(Task task);
    void addTask(Task task);
}
