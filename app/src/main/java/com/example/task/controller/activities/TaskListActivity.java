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

public class TaskListActivity extends SingleFragmentActivity {
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,TaskListActivity.class);
        return intent;
    }

    @Override
    public Fragment createFragment() {
        return TaskListFragment.newInstance();
    }
}