package com.example.task.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.example.task.Repository.TaskRepository;

import java.util.Date;
import java.util.UUID;
@Entity(tableName = "userTable")
public class User {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "uuid")
    private UUID mUUID;
    @ColumnInfo(name = "username")
    private String mUserName;
    @ColumnInfo(name = "password")
    private String mPassword;
    @Ignore
    private TaskRepository mTaskList ;

    public User(String userName, String password ) {
//        mTaskList = TaskRepository.getInstance(context);
        mUUID = UUID.randomUUID();
        mUserName = userName;
        mPassword = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUUID(UUID UUID) {
        mUUID = UUID;
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
