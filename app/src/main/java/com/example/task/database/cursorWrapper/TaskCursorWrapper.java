package com.example.task.database.cursorWrapper;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.task.database.TaskDBSchema;
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
        Task task = new Task(UUID.fromString(getString(getColumnIndex(TaskDBSchema.TaskTable.COLS.UUID))),
                getString(getColumnIndex(TaskDBSchema.TaskTable.COLS.NAME)),
                State.valueOf(getString(getColumnIndex(TaskDBSchema.TaskTable.COLS.STATE))),
                new Date(getString(getColumnIndex(TaskDBSchema.TaskTable.COLS.DATE))),
                getString(getColumnIndex(TaskDBSchema.TaskTable.COLS.DESCRIPTION)),
                new Timer(getString(getColumnIndex(TaskDBSchema.TaskTable.COLS.TIME))));
        return task;
    }
}
