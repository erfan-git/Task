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
public interface TaskDataBaseDAO {
    @Insert
    void insertTask(Task task);

    @Insert
    void insertTasks(List<Task> tasks);

    @Update
    void updateTask(Task task);

    @Delete
    void deleteTask(Task task);

    @Query("SELECT * FROM taskTable")
    List<Task> getTasks();

    @Query("SELECT * FROM taskTable WHERE uuid=:uuid")
    Task getTask(String uuid);

    @Query("Delete FROM taskTable")
    void clear();
}
