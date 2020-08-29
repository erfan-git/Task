package com.example.task.database.cursorWrapper;

import android.database.Cursor;
import android.database.CursorWrapper;


import com.example.task.database.TaskDBSchema.TaskTable.COLS;
import com.example.task.model.State;
import com.example.task.model.Task;

import java.util.Date;
import java.util.Timer;
import java.util.UUID;

public class TaskCursorWrapper extends CursorWrapper {
    public TaskCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Task getTask() {
        Task task = new Task(UUID.fromString(getString(getColumnIndex(COLS.UUID))),
                getString(getColumnIndex(COLS.NAME)),
                State.valueOf(getString(getColumnIndex(COLS.STATE))),
                new Date(getString(getColumnIndex(COLS.DATE))),
                getString(getColumnIndex(COLS.DESCRIPTION)),
                UUID.fromString(getString(getColumnIndex(COLS.USER_UUID))));
        return task;
    }
}
