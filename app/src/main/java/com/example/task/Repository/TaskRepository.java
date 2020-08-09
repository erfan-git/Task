package com.example.task.Repository;

import com.example.task.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepository implements Repository {
    private static TaskRepository sTaskRepository;

    public static TaskRepository getInstance() {
        if (sTaskRepository == null) {
            sTaskRepository = new TaskRepository();
        }
        return sTaskRepository;
    }

    private List<Task> mTasks;

    private TaskRepository(){
        mTasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return mTasks;
    }

    public void setTasks(List<Task> tasks) {
        mTasks = tasks;
    }

    @Override
    public void addTask(Task task) {
        mTasks.add(task);
    }

    @Override
    public List<Task> getTask() {
        return mTasks;
    }

    @Override
    public Task getTask(UUID uuid) {
        for (Task task : mTasks) {
            if (task.getId().equals(uuid)){
                return task;
            }
        }
        return null;
    }

    @Override
    public void updateTask(Task task) {
        Task updateTask = getTask(task.getId());
        updateTask.setName(task.getName());
        updateTask.setState(task.getState());
    }

    @Override
    public void deleteTask(Task task) {
        for (int i = 0; i < mTasks.size(); i++) {
            if (mTasks.get(i).getId().equals(task.getId())) {
                mTasks.remove(i);
            }
        }
    }
}
