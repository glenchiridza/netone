package com.glencconnnect.net1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.glencconnnect.net1.R;

public class OneMoneFragment extends Fragment {


    public OneMoneFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout
        return inflater.inflate(R.layout.fragment_one_mone, container, false);
    }
}