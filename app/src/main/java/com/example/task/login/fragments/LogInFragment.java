package com.example.task.login.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.task.R;


public class LogInFragment extends Fragment {
    private EditText mEditTextUserName;
    private EditText mEditTextPassword;
    private Button mButtonLogIn;
    private Button mButtonSign;

    public LogInFragment() {
        // Required empty public constructor
    }

    public static LogInFragment newInstance() {
        LogInFragment fragment = new LogInFragment();
        Bundle args = new Bundle();
//        args.putSerializable();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);
        findAllViews(view);
        setClickListeners(view);
        return view;
    }

    private void setClickListeners(View view) {
        mEditTextUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().length() != 0) {
//                    mNameOfTasks = charSequence.toString();
                } else {
//                    mNameOfTasks = "";
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
//
            }
        });
    }

    private void findAllViews(View view) {
        mEditTextUserName = view.findViewById(R.id.editText_userName);
        mEditTextPassword = view.findViewById(R.id.editText_password);
        mButtonLogIn = view.findViewById(R.id.button_log_in);
        mButtonSign = view.findViewById(R.id.button_sign_up);
    }
}