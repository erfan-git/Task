package com.example.task.Repository;

import com.example.task.Repository.Repository;
import com.example.task.model.Task;

import java.util.List;
import java.util.UUID;

public class TaskRepository implements Repository {

    @Override
    public List<Task> getTask() {
        return null;
    }

    @Override
    public Task getTask(UUID uuid) {
        return null;
    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    public void deleteTask(Task task) {

    }
}
