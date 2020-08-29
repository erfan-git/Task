package com.example.task.Repository;

import android.content.Context;

import androidx.room.Room;

import com.example.task.database.TaskDataBase;
import com.example.task.model.Task;
import com.example.task.model.User;

import java.util.List;
import java.util.UUID;

public class UserRepository implements IRepository<User> {

    private static UserRepository sUserRepository;
    private static Context mContext;

    public static UserRepository getInstance(Context context) {
        mContext = context.getApplicationContext();
        if (sUserRepository == null) {
            sUserRepository = new UserRepository();
        }
        return sUserRepository;
    }

    private TaskDataBase mDatabase;
    private User mUser;
    private List<Task> mTasks;

    private UserRepository() {
        mDatabase = Room.databaseBuilder(mContext, TaskDataBase.class, "UserDB.db").allowMainThreadQueries().build();
    }

    @Override
    public List<User> getList() {
        return mDatabase.UserDao().getUsers();
    }

    @Override
    public User get(UUID uuid) {
        return mDatabase.UserDao().getUser(uuid.toString());
    }

    @Override
    public void update(User user) {
        mDatabase.UserDao().updateUser(user);
    }

    @Override
    public void delete(User user) {
        mDatabase.UserDao().deleteUser(user);
    }

    @Override
    public void insert(User user) {
        mDatabase.UserDao().insertUser(user);
    }

    @Override
    public void insertList(List<User> list) {
        User[] itemsArray=new User[list.size()];
        itemsArray = list.toArray(itemsArray);
        mDatabase.UserDao().insertUsers(itemsArray);
    }

    @Override
    public int getPosition(UUID uuid) {
        return 0;
    }

}
