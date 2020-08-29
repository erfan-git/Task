package com.example.task.login.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.task.R;
import com.example.task.Repository.UserRepository;
import com.example.task.model.User;
import com.google.android.material.textfield.TextInputLayout;


public class LogInFragment extends Fragment {
    private EditText mEditTextUsername, mEditTextPassword;
    private Button mButtonLogIn, mButtonSign;
    private CheckBox mCheckBoxAdmin;
    private TextInputLayout mTextInputLayoutUsername, mTextInputLayoutPassword;

    private UserRepository mUserRepository;

    public LogInFragment() {
        // Required empty public constructor
    }

    public static LogInFragment newInstance() {
        LogInFragment fragment = new LogInFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserRepository = UserRepository.getInstance(getContext());
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
        mTextInputLayoutUsername.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.toString().length() > 0)
                    mTextInputLayoutUsername.setErrorEnabled(false);
                else
                    mTextInputLayoutUsername.setErrorEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mTextInputLayoutPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.toString().length() > 0)
                    mTextInputLayoutPassword.setErrorEnabled(false);
                else
                    mTextInputLayoutPassword.setErrorEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mButtonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!textValidation() || !signInValidation())
                    return;

                mEditTextUsername.setText("");
                mEditTextPassword.setText("");

                mTextInputLayoutUsername.setHint("Username");
                mTextInputLayoutPassword.setHint("Password");


                mEditTextUsername.setFocusable(false);
                mEditTextPassword.setFocusable(false);
                mEditTextUsername.setFocusableInTouchMode(true);
                mEditTextPassword.setFocusableInTouchMode(true);


//                startActivity(TaskViewPagerActivity.newIntent(getActivity()));
            }
        });

        mButtonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!textValidation())
                    return;

                if (usernameValidation()) {
                    Toast.makeText(getActivity(), "There is an user with this 'Username'.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (mUserRepository.getList().size() == 0) {
                    if (!mCheckBoxAdmin.isChecked()) {
                        Toast.makeText(getActivity(), "First of all 'Admin user' should be set.\nPlease check the admin checkbox to sign up. ", Toast.LENGTH_LONG).show();
                    } else {
                        mUserRepository.insert(new User(mEditTextUsername.getText().toString(), mEditTextPassword.getText().toString()));
                        setCheckBoxAdmin();
                    }
                    return;
                }


                mUserRepository.insert(new User(mEditTextUsername.getText().toString(), mEditTextPassword.getText().toString()));
                setCheckBoxAdmin();
            }
        });

//        mEditTextUserName.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if (charSequence.toString().length() != 0) {
////                    mNameOfTasks = charSequence.toString();
//                } else {
////                    mNameOfTasks = "";
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
////
//            }
//        });


    }

    private boolean textValidation() {

        if (mEditTextUsername.getText().toString().length() == 0 && mEditTextPassword.getText().toString().length() == 0) {
            mTextInputLayoutUsername.setError("Username should be fill");
            mTextInputLayoutPassword.setError("Password should be fill");
            return false;
        } else if (mEditTextUsername.getText().toString().length() == 0) {
            mTextInputLayoutUsername.setError("Username should be fill");
            return false;
        } else if (mEditTextPassword.getText().toString().length() == 0) {
            mTextInputLayoutPassword.setError("Password should be fill");
            return false;
        }
        return true;
    }

    private boolean signInValidation() {

        for (int i = 0; i < mUserRepository.getList().size(); i++) {
            if (mUserRepository.getList().get(i).getUserName().equals(mEditTextUsername.getText().toString())) {
                for (int j = 0; j < mUserRepository.getList().size(); j++) {
                    if (mUserRepository.getList().get(j).getPassword().equals(mEditTextPassword.getText().toString())) {
                        return true;
                    }
                }
                Toast.makeText(getActivity(), "Oops! Password is wrong.", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        Toast.makeText(getActivity(), "There is no such user", Toast.LENGTH_SHORT).show();
        return false;

    }

    private boolean usernameValidation() {
        for (int i = 0; i < mUserRepository.getList().size(); i++) {
            if (mUserRepository.getList().get(i).getUserName().equals(mEditTextUsername.getText().toString())) {
                return true;
            }
        }
        return false;
    }

    private void findAllViews(View view) {
        mEditTextUsername = view.findViewById(R.id.editText_userName);
        mEditTextPassword = view.findViewById(R.id.editText_password);
        mTextInputLayoutUsername = view.findViewById(R.id.textInputLayoutUsername);
        mTextInputLayoutPassword = view.findViewById(R.id.textInputLayoutPassword);
        mButtonLogIn = view.findViewById(R.id.button_log_in);
        mButtonSign = view.findViewById(R.id.button_sign_up);
        mCheckBoxAdmin = view.findViewById(R.id.checkBoxAdmin);

        setCheckBoxAdmin();
    }

    private void setCheckBoxAdmin() {
        if (mUserRepository.getList().size() > 0) {
            mCheckBoxAdmin.setChecked(false);
            mCheckBoxAdmin.setEnabled(false);
        }
    }
}