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

import com.example.task.R;

public class EnterFragment extends Fragment {

    private EditText mEditTextName;
    private EditText mEditTextNumber;
    private Button mButtonSave;
    public static int mNumberOfTasks;
    public static String mNameOfTasks;

    public EnterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (savedInstanceState != null) {
//            mTicTocToeX = (TicTocToe) savedInstanceState.getSerializable(KAY_BUNDLE_TIC_TAC_TOE);
//            update();
//        } else {
//            mTicTocToeX = new TicTocToe(NameOfTicTocToe.X);
//        }
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

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mNameOfTasks = mEditTextName.getText().toString();
            }
        });

        mEditTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
//mNumberOfTasks = Integer.mEditTextNumber.getText()

            }
        });

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNameOfTasks = mEditTextName.getText().toString();
//                mNameOfTasks = Integer.parseInt (mEditTextNumber.getText().toString());
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