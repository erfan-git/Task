package com.example.task.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static com.example.task.database.UserDBSchema.UserTable.NAME;
import static com.example.task.database.UserDBSchema.UserTable.COLS;

public class UserBaseHelper extends SQLiteOpenHelper {

    public UserBaseHelper(@Nullable Context context) {
        super(context, UserDBSchema.NAME, null, UserDBSchema.VERSION);
    }

    /**
     * create the database with all tables, constraints, ...
     * it's like implementing the ERD.
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NAME + "(" +
                COLS.ID + " integer primary key autoincrement," +
                COLS.UUID + " text," +
                COLS.USERNAME + " text," +
                COLS.PASSWORD + " long" +
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
