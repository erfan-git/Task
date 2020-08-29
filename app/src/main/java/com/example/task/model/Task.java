package com.example.task.model;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Task {
    private UUID mId;
    private UUID mUserId;
    private String mTitle,mDescription;
    private State mState;
    private Date mDate;

    public Task(String title,UUID uuid) {
        mTitle = title;
        mUserId = uuid;
        mId = UUID.randomUUID();
        mState = randomLetter();
//        this(UUID.randomUUID(),randomLetter());
    }

    public Task(UUID uuid,State state) {
        mId = uuid;
        mState = state;
        mDate = new Date();
    }

    public Task(UUID id, String name, State state, Date date, String description) {
        mId = id;
        mTitle = name;
        mState = state;
        mDate = date;
        mDescription = description;
    }

    public Task(UUID id,String name, State state, Date date, String description,UUID userId) {
        mId = id;
        mUserId = userId;
        mTitle = name;
        mState = state;
        mDate = date;
        mDescription = description;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setState(State state) {
        mState = state;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
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
