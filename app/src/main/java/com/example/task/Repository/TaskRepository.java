package com.example.task.Repository;

import com.example.task.Repository.Repository;
import com.example.task.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.task.controller.fragments.EnterFragment.mNameOfTasks;
import static com.example.task.controller.fragments.EnterFragment.mNumberOfTasks;

public class TaskRepository implements Repository {
    public static final int NUMBER_OF_TASKS = mNumberOfTasks;
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
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            Task task = new Task();
            task.setName(mNameOfTasks);

            mTasks.add(task);
        }
    }

    public List<Task> getTasks() {
        return mTasks;
    }

    public void setTasks(List<Task> tasks) {
        mTasks = tasks;
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
