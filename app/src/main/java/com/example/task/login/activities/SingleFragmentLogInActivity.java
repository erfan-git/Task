package com.example.task.login.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.task.R;

public abstract class SingleFragmentLogInActivity extends AppCompatActivity {

    public static final String FRAGMENT_TAG = "FragmentActivity";

    public abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.log_in_container);
        if (fragment == null) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.log_in_container, createFragment(), FRAGMENT_TAG)
                    .commit();
        }
    }
}
