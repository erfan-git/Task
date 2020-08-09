package com.example.task.controller.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.task.R;
import com.example.task.controller.fragments.EnterFragment;
import com.example.task.controller.fragments.TaskListFragment;

public class TaskListActivity extends AppCompatActivity {
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,TaskListActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        Fragment mFragment = mFragmentManager.findFragmentById(R.id.frameLayout_container);
        if (mFragment == null){
            mFragmentManager
                    .beginTransaction()
                    .add(R.id.frameLayout_container, new TaskListFragment())
                    .commit();
        }
    }
}