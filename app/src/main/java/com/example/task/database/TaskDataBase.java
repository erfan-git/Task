package com.example.task.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.task.utils.DateConverter;
import com.example.task.utils.UUIDConverter;
import com.example.task.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
@TypeConverters({UUIDConverter.class, DateConverter.class})
public abstract class TaskDataBase extends RoomDatabase {
    public abstract UserDataBaseDAO UserDao();
}
