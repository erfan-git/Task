package com.example.task.database;

public class TaskDBSchema {
    public static final String NAME = "TaskDB.db";
    public static final int VERSION = 1;

    public static final class TaskTable {
        public static final String NAME = "TaskTable";

        public static final class COLS {
            public static final String ID = "id";
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String DESCRIPTION = "description";
            public static final String DATE = "date";
            public static final String TIME = "time";
            public static final String STATE = "state";
        }
    }
}
