package com.example.task.controller.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.task.R;

public class EnterFragment extends Fragment {

    private EditText mEditTextName;
    private EditText mEditTextNumber;

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

            }
        });

    }

    private void findAllViews(View view) {
        mEditTextName = view.findViewById(R.id.editText_question_name);
        mEditTextNumber = view.findViewById(R.id.editText_question_number);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}