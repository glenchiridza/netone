package com.glencconnnect.net1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.glencconnnect.net1.adapter.MyCodeAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCodesActivity extends AppCompatActivity {

    private static final String SHAREDCODE = "starred_dial_code";
    private static final String SHAREDCODE2 = "starred_code";
    private Toolbar toolbar;
    public static final String PREF_KEY = "com.glencconnect.net1.preference";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private EditText editCodeTitle;
    private EditText editCode;
    private Button btnSave;
    private List<String> savedCodes;
    private RecyclerView recyclerView;
    private MyCodeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_codes);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        savedCodes = new ArrayList<>();

        loadData();

        //edit texts
        editCodeTitle = findViewById(R.id.edit_shortcode_title);
        editCode = findViewById(R.id.edit_short_code);
        btnSave = findViewById(R.id.btn_save);

        sharedPreferences = getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        editor = sharedPreferences.edit();


        btnSave.setOnClickListener(view -> {

            savedCodes.add(editCodeTitle.getText().toString());
            adapter.notifyItemInserted(savedCodes.size());
//            saveData();
        });

        //setup recyclerview
        recyclerView = findViewById(R.id.dial_codes_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new MyCodeAdapter(this, savedCodes);
        recyclerView.setAdapter(adapter);


    }


    private void loadData() {
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_KEY, MODE_PRIVATE);

        // below line is to get to string present from our
        // shared prefs if not present setting it as null.
        String json = sharedPreferences.getString(SHAREDCODE, null);


        savedCodes = Collections.singletonList(json);
        // checking below if the array list is empty or not
        if (savedCodes == null) {
            // if the array list is empty
            // creating a new array list.
            savedCodes = new ArrayList<>();
        }
    }

    private void saveData() {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_KEY, MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();


        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString(SHAREDCODE, String.valueOf(savedCodes));

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();

        // after saving data we are displaying a toast message.
        Toast.makeText(this, "Saved Array List to Shared preferences. ", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onPause() {
        loadData();
        super.onPause();
    }

    @Override
    protected void onResume() {
        loadData();
        super.onResume();
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

//    @Override
//    protected void onStop() {
//        for (int i =0;i<savedCodes.size();i++){
//            editor.putString(SHAREDCODE+i,savedCodes.get(i));
//        }
//        editor.apply();
//        super.onStop();
//    }
}