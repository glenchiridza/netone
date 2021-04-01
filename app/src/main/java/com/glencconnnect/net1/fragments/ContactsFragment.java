package com.glencconnnect.net1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.glencconnnect.net1.R;


public class ContactsFragment extends Fragment {



    public ContactsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflating the layout
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }
}