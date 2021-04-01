package com.glencconnnect.net1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.glencconnnect.net1.MainActivity;
import com.glencconnnect.net1.R;
import com.glencconnnect.net1.adapter.ContentAdapter;


public class ContactsFragment extends Fragment {


    public static final String DATA = "com.glencconnect.data";
    private RecyclerView recyclerView;

    public ContactsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflating the layout
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        //setting title
        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.setFragmentTitle("Contacts");

        //setting recyclerview
        recyclerView  = view.findViewById(R.id.contacts_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ContentAdapter(getContext()));

        return view;
    }

}