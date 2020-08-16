package com.example.task.login.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.task.R;
import com.example.task.login.fragments.LogInFragment;

public class LogInActivity extends AppCompatActivity {
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, LogInActivity.class);
        return intent;
    }

    public static final String FRAGMENT_TAG = "FragmentLogIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.frameLayout_container);
        if (fragment == null) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.log_in_container, LogInFragment.newInstance() , FRAGMENT_TAG)
                    .commit();
        }
    }
}