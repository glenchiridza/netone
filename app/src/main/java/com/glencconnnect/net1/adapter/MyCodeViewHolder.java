/**
 * Created by glenc on Apr 2021
 **/

package com.glencconnnect.net1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.glencconnnect.net1.ContentViewActivity;
import com.glencconnnect.net1.MainActivity;
import com.glencconnnect.net1.R;
import com.glencconnnect.net1.fragments.ContactsFragment;

class MyCodeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView codeTitle;
    private Context context;


    //retrieve data hold
    private String dial_code;
    private MainActivity mainActivity = new MainActivity();

    public MyCodeViewHolder(@NonNull View itemView) {
        super(itemView);
        codeTitle = itemView.findViewById(R.id.my_code);
        itemView.setOnClickListener(this);
    }

    public static MyCodeViewHolder create(ViewGroup parent) {

        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_code,parent,false);
        return new MyCodeViewHolder(view);
    }

    public void bind(String mycode){

        dial_code = mycode;

        codeTitle.setText(mycode);

    }

    public void getContext(Context context){
        //get context
        this.context = context;
    }

    @Override
    public void onClick(View view) {

        mainActivity.universalDial("1212");
    }
}


