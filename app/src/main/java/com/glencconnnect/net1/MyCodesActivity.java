package com.glencconnnect.net1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.glencconnnect.net1.adapter.MyCodeAdapter;
import com.glencconnnect.net1.models.MyCodes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCodesActivity extends AppCompatActivity {

    private static final String SHAREDCODE = "starred_dial_code";
    private Toolbar toolbar;
    public static final String PREF_KEY = "com.glencconnect.net1.preference";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private EditText editCodeTitle;
    private EditText editCode;
    private Button btnSave;
    private List<MyCodes> savedCodes;
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

//        savedCodes = new ArrayList<>();

        //edit texts
        editCodeTitle = findViewById(R.id.edit_shortcode_title);
        editCode = findViewById(R.id.edit_short_code);
        btnSave = findViewById(R.id.btn_save);

        //load shared pref
        loadData();


        sharedPreferences = getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        editor = sharedPreferences.edit();


        btnSave.setOnClickListener(view -> {

            savedCodes.add(new MyCodes(editCodeTitle.getText().toString(),editCode.getText().toString()));
            adapter.notifyItemInserted(savedCodes.size());
            saveData();
        });



        //setup recyclerview
        recyclerView = findViewById(R.id.dial_codes_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new MyCodeAdapter(this, savedCodes);
        recyclerView.setAdapter(adapter);

        //itemswipe event
        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int pos = viewHolder.getAdapterPosition();
                savedCodes.remove(pos);
                editor.clear();
                saveData();
                adapter.notifyDataSetChanged();

                recyclerView.scrollToPosition(0);

            }
        });

//        invoke touch helper on recyclerview
        touchHelper.attachToRecyclerView(recyclerView);


    }


    private void loadData() {
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_KEY, MODE_PRIVATE);

        // creating a variable for gson.
        Gson gson = new Gson();

        // get the type of our array list.
        Type type = new TypeToken<ArrayList<MyCodes>>() {}.getType();


        // get string present from sharedpref
        String json = sharedPreferences.getString(SHAREDCODE, null);

        // getting data from gson
        // and saving it to our array list
        savedCodes = gson.fromJson(json, type);



        // checking below if the array list is empty or not
        if (savedCodes == null) {
            // creating a new array list. if list is empty
            savedCodes = new ArrayList<>();
        }
    }

    private void saveData() {


        // store data in shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_KEY, MODE_PRIVATE);

        //editor to store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(savedCodes);


        //save to shared prefs in the form of string.
        editor.putString(SHAREDCODE, json);

        //apply changes
        editor.apply();

        // after saving data we are displaying a toast message.
        Toast.makeText(this, "Short codes updated ", Toast.LENGTH_SHORT).show();
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