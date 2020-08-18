package com.example.task.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static com.example.task.database.TaskDBSchema.NAME;
import static com.example.task.database.TaskDBSchema.TaskTable.COLS;

public class TaskBaseHelper extends SQLiteOpenHelper {

    public TaskBaseHelper(@Nullable Context context) {
        super(context, NAME, null, TaskDBSchema.VERSION);
    }

    /**
     * create the database with all tables, constraints, ...
     * it's like implementing the ERD.
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TaskDBSchema.TaskTable.NAME + "(" +
                COLS.ID + " integer primary key autoincrement," +
                COLS.UUID + " text," +
                COLS.TIME + " text," +
                COLS.NAME + " text," +
                COLS.DATE + " long," +
                COLS.STATE + " text" +
                ");");
    }

    /**
     * update the database with all alters.
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
