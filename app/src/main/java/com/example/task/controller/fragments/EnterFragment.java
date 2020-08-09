package com.example.task.controller.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.task.R;
import com.example.task.Repository.TaskRepository;
import com.example.task.controller.activities.EnterActivity;
import com.example.task.controller.activities.TaskListActivity;
import com.example.task.model.Task;

public class EnterFragment extends Fragment {

    private EditText mEditTextName;
    private EditText mEditTextNumber;
    private Button mButtonSave;
    private int mNumberOfTasks;
    private String mNameOfTasks = "";
    private TaskRepository mTaskRepository;

    public EnterFragment() {
        // Required empty public constructor
    }

    public static EnterFragment newInstance() {

        Bundle args = new Bundle();

        EnterFragment fragment = new EnterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTaskRepository = TaskRepository.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter, container, false);
        findAllViews(view);
        setClickListeners(view);
        return view;
    }

    private void setClickListeners(View view) {
        mEditTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().length() != 0) {
                    mNameOfTasks = charSequence.toString();
                } else {
                    mNameOfTasks = "";
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
//
            }
        });

        mEditTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().length() != 0) {
                    mNumberOfTasks = Integer.parseInt(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mNameOfTasks.length() == 0 && mNumberOfTasks == 0) {
                    mEditTextName.setError(getString(R.string.error_empty_name));
                    mEditTextNumber.setError(getString(R.string.error_empty_number));
                } else if (mNameOfTasks.length() == 0) {
                    mEditTextName.setError(getString(R.string.error_empty_name));
                } else if (mEditTextNumber.getText().toString().length() == 0) {
                    mEditTextNumber.setError(getString(R.string.error_empty_number));
                } else if (mNumberOfTasks == 0) {
                    mEditTextNumber.setError("Number of task cant be zero !!");
                } else {
                    mNameOfTasks = mEditTextName.getText().toString();
                    mNumberOfTasks = Integer.parseInt(mEditTextNumber.getText().toString());
                    for (int i = 0; i < mNumberOfTasks; i++) {
                        Task task = new Task(mNameOfTasks);
                        mTaskRepository.addTask(task);
                    }
                    startActivity(TaskListActivity.newIntent(getActivity()));
                }
            }
        });

    }

    private void findAllViews(View view) {
        mEditTextName = view.findViewById(R.id.editText_question_name);
        mEditTextNumber = view.findViewById(R.id.editText_question_number);
        mButtonSave = view.findViewById(R.id.button_create_task);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}