package com.example.task.controller.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.task.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    public static final String FRAGMENT_TAG = "FragmentActivity";

    public abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.frameLayout_container);
        if (fragment == null) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frameLayout_container, createFragment(), FRAGMENT_TAG)
                    .commit();
        }
    }
}
