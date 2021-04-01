package com.glencconnnect.net1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.glencconnnect.net1.fragments.ContactsFragment;

public class ContentViewActivity extends AppCompatActivity {

    private TextView office;
    private TextView address;
    private TextView phone;
    private TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_view);
        //initialize views
        init();

        //get data from intent

        Intent intent = getIntent();

        if (intent.getStringArrayExtra(ContactsFragment.DATA) !=null){
            String[] shopDetails = intent.getStringArrayExtra(ContactsFragment.DATA);

            shopDetails(shopDetails);
        }
    }

    private void shopDetails(String[] shopDetails) {

        office.setText(shopDetails[0]);

        //split and set address
        address.setText(shopDetails[1]);

        phone.setText(shopDetails[2]);
        email.setText(shopDetails[3]);

    }

    //method to initialize views
    private void init(){
        office = findViewById(R.id.id_office);
        address = findViewById(R.id.id_address);
        phone = findViewById(R.id.id_phone);
        email = findViewById(R.id.id_email);
    }
}