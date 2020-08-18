package com.example.task.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.task.database.TaskBaseHelper;
import com.example.task.database.cursorWrapper.TaskCursorWrapper;
import com.example.task.database.TaskDBSchema;
import com.example.task.database.TaskDBSchema.TaskTable.COLS;
import com.example.task.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepository implements IRepository<Task> {
    private static TaskRepository sTaskRepository;
    private static Context mContext;
    private SQLiteDatabase mDatabase;

    public static TaskRepository getInstance(Context context) {
        mContext = context.getApplicationContext();
        if (sTaskRepository == null) {
            sTaskRepository = new TaskRepository();
        }
        return sTaskRepository;
    }

    private List<Task> mTasks;

    private TaskRepository() {
        TaskBaseHelper crimeBaseHelper = new TaskBaseHelper(mContext);
        mDatabase = crimeBaseHelper.getWritableDatabase();
    }

    public List<Task> getTasks() {
        return mTasks;
    }

    public void setTasks(List<Task> tasks) {
        mTasks = tasks;
    }

    @Override
    public void add(Task task) {
        mTasks.add(task);
    }

    @Override
    public void insert(Task task) {
        mDatabase.insert(TaskDBSchema.TaskTable.NAME, null, getTaskContentValues(task));
    }

    @Override
    public void insertList(List<Task> list) {

    }

    @Override
    public int getPosition(UUID uuid) {
        List<Task> tasks = getList();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(uuid)) {
                return i;
            }
        }

        return 0;
    }

    @Override
    public List<Task> getList() {
        List<Task> taskList = new ArrayList<>();
        TaskCursorWrapper cursor = queryTasks(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                taskList.add(cursor.getTask());

                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return taskList;
    }

    private TaskCursorWrapper queryTasks(String o, String[] o2) {
        Cursor cursor = mDatabase.query(TaskDBSchema.TaskTable.NAME,
                null,
                o,
                o2,
                null,
                null,
                null);

        TaskCursorWrapper taskCursorWrapper = new TaskCursorWrapper(cursor);
        return taskCursorWrapper;
    }

    @Override
    public Task get(UUID uuid) {

        String selection = COLS.UUID + "=?";
        String[] selectionArgs = new String[]{uuid.toString()};
        TaskCursorWrapper cursor = queryTasks(selection, selectionArgs);

        try {
            cursor.moveToFirst();
            return cursor.getTask();

        } finally {
            cursor.close();
        }
    }

    @Override
    public void update(Task task) {
        String where = COLS.NAME + "=?";
        String[] whereArgs = new String[]{task.getId().toString()};
        mDatabase.update(TaskDBSchema.TaskTable.NAME, getTaskContentValues(task), where, whereArgs);
    }

    @Override
    public void delete(Task task) {
        String where = COLS.NAME + "=?";
        String[] whereArgs = new String[]{task.getId().toString()};
        mDatabase.delete(TaskDBSchema.TaskTable.NAME, where, whereArgs);
    }

    /**
     * convert task pojo to contentValues
     *
     * @param task
     * @return ContentValues
     */
    private ContentValues getTaskContentValues(Task task) {
        ContentValues values = new ContentValues();
        values.put(COLS.UUID, task.getId().toString());
        values.put(COLS.NAME, task.getName());
        values.put(COLS.STATE, task.getState().toString());
        values.put(COLS.TIME, task.getTime().toString());
        values.put(COLS.DATE, task.getDate().toString());
        values.put(COLS.DESCRIPTION, task.getDescription());
        return values;
    }
}
