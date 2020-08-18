package com.example.task.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.UUID;

public class Task {
    private UUID mId;
    private String mName;
    private State mState;
    private Date mDate;
    private Timer mTime;
    private String mDescription = "";

    public Task(String name) {
        mName = name;
        mId = UUID.randomUUID();
        mState = randomLetter();
//        this(UUID.randomUUID(),randomLetter());
    }

    public Task(UUID uuid,State state) {
        mId = uuid;
        mState = state;
        mDate = new Date();
        mTime = new Timer();
    }

    public Task(UUID id, String name, State state, Date date, String description, Timer time) {
        mId = id;
        mName = name;
        mState = state;
        mDate = date;
        mTime = time;
        mDescription = description;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Timer getTime() {
        return mTime;
    }

    public void setTime(Timer time) {
        mTime = time;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

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

    public Task() {
        mId = UUID.randomUUID();
    }

    private State randomLetter() {
        int pick = new Random().nextInt(State.values().length);
        return State.values()[pick];
    }
}
