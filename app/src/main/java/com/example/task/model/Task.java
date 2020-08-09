package com.example.task.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
        mState = randomLetter();
    }

    public Task() {
        mId = UUID.randomUUID();
    }

    private State randomLetter() {
        int pick = new Random().nextInt(State.values().length);
        return State.values()[pick];
    }
}
