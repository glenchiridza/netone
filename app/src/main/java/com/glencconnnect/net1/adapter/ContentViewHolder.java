/**
 * Created by glenc on Apr 2021
 **/

package com.glencconnnect.net1.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.glencconnnect.net1.ContentViewActivity;
import com.glencconnnect.net1.R;
import com.glencconnnect.net1.fragments.ContactsFragment;

class ContentViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView addressTitle;
    private Context context;

    //retrieve data hold
    private String office;
    private String address;
    private String phone;
    private String email;

    private String[] dataArr;

    public ContentViewHolder(@NonNull View itemView) {
        super(itemView);
        addressTitle = itemView.findViewById(R.id.office_name_id);
        itemView.setOnClickListener(this);
    }

    public static ContentViewHolder create(ViewGroup parent) {

        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);
        return new ContentViewHolder(view);
    }

    public void bind(String office, String address,String phone, String email){

        //send to ContentViewActivity
        this.office = office;
        this.address = address;
        this.phone = phone;
        this.email = email;

        //send array with data to ContentViewActivity
        dataArr = new String[]{office,address,phone,email};


        //set Recycler Title
        addressTitle.setText(office);

    }

    public void getContext(Context context){
        //get context
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent( context, ContentViewActivity.class);
        intent.putExtra(ContactsFragment.DATA,dataArr);
        context.startActivity(intent);
    }
}


