package com.glencconnnect.net1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.glencconnnect.net1.fragments.ContactsFragment;

import java.util.Objects;

public class ContentViewActivity extends AppCompatActivity {

    private TextView office;
    private TextView address;
    private TextView phone;
    private TextView email;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_view);

        toolbar = findViewById(R.id.shop_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}