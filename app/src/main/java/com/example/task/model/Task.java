package com.example.task.model;

import java.util.UUID;

public class Task {
    private UUID mId;
    private String mName;
    private State mState;

    public void setName(String name) {
        mName = name;
    }

    public void setState(State state) {
        mState = state;
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public State getState() {
        return mState;
    }

    public Task(String name) {
        mName = name;
        mId = UUID.randomUUID();
//        mState = new Random(State.)
    }
}
