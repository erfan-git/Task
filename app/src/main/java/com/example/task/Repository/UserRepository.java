package com.example.task.Repository;

import com.example.task.model.Task;
import com.example.task.model.User;

import java.util.List;
import java.util.UUID;

public class UserRepository implements IRepository<User> {


    @Override
    public List<User> getTask() {
        return null;
    }

    @Override
    public User getTask(UUID uuid) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void add(User user) {

    }

    @Override
    public void insert(User user) {

    }

    @Override
    public void insertList(List<User> list) {

    }

    @Override
    public int getPosition(UUID uuid) {
        return 0;
    }


}
