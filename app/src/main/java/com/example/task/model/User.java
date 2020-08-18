package com.example.task.model;

import com.example.task.Repository.TaskRepository;

import java.util.List;
import java.util.UUID;

public class User {
    private UUID mUUID;
    private String mUserName;
    private String mPassword;
    private List<Task> mTaskList ;

    public User( String userName, String password) {
//        mTaskList = TaskRepository.getInstance().getTasks();
        mUUID = UUID.randomUUID();
        mUserName = userName;
        mPassword = password;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
