package com.example.task;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EnterFragment extends Fragment {

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_enter, container, false);


        return view;
    }
}