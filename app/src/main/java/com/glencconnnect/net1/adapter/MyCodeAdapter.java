/**
 * Created by glenc on Apr 2021
 **/

package com.glencconnnect.net1.adapter;


import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.glencconnnect.net1.models.Contacts;
import com.glencconnnect.net1.models.MyCodes;

import java.util.List;

public class MyCodeAdapter extends RecyclerView.Adapter<MyCodeViewHolder> {

    private Context context;
    private List<MyCodes> savedCodes;
    public MyCodeAdapter(Context context, List<MyCodes> savedCodes) {
        this.context = context;
        this.savedCodes = savedCodes;


    }

    @NonNull
    @Override
    public MyCodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyCodeViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCodeViewHolder holder, int position) {

        MyCodes myCode = savedCodes.get(position);

        holder.bind(myCode);
        holder.getContext(context);
    }

    @Override
    public int getItemCount() {
        return savedCodes.size();
    }

}


