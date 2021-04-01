package com.glencconnnect.net1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.glencconnnect.net1.MainActivity;
import com.glencconnnect.net1.R;


public class HomeFragment extends Fragment {



    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.setFragmentTitle("Dashboard");

        // Inflate the layout
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}