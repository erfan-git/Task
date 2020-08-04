package com.example.task.controller.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.task.R;
import com.example.task.controller.fragments.EnterFragment;


public class EnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        Fragment mFragment = mFragmentManager.findFragmentById(R.id.frameLayout_container);
        if (mFragment == null){
            mFragmentManager
                    .beginTransaction()
                    .add(R.id.frameLayout_container, new EnterFragment())
                    .commit();
        }

    }
}