package com.example.task.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.task.model.Task;
import com.example.task.model.User;

import java.util.List;

@Dao
public interface UserDataBaseDAO {
    @Insert
    void insertUser(User user);

    @Insert
    void insertUsers(User...users);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM userTable")
    List<User> getUsers();

    @Query("SELECT * FROM userTable WHERE uuid=:uuid")
    User getUser(String uuid);

    @Query("Delete FROM userTable")
    void clear();
}
