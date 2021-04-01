/**
 * Created by glenc on Apr 2021
 **/

package com.glencconnnect.net1.adapter;


import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.glencconnnect.net1.models.Contacts;

public class ContentAdapter extends RecyclerView.Adapter<ContentViewHolder> {

    private Context context;
    public ContentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ContentViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {

        String office = Contacts.offices[position];
        String address = Contacts.addresses[position];
        String phone  = Contacts.phone_num[position];
        //we have single email, so return that one for all
        String email = Contacts.emails[0];

        holder.bind(office, address, phone, email);
        holder.getContext(context);
    }

    @Override
    public int getItemCount() {
        return Contacts.addresses.length;
    }
}


