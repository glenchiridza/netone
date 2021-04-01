package com.glencconnnect.net1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_nav);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                bottomNavItemSelected(item);
                return false;
            }
        });

    }

    private boolean bottomNavItemSelected(MenuItem item) {
       int id = item.getItemId();
            if(id == R.id.nav_home){

                Toast.makeText(this, "clicked home", Toast.LENGTH_SHORT).show();
                return true;

            }

            else if(id == R.id.nav_one_money){

                Toast.makeText(this, "clicked money", Toast.LENGTH_SHORT).show();
                return true;
            }

            else if(id == R.id.nav_contacts){

                Toast.makeText(this, "clicked contact", Toast.LENGTH_SHORT).show();
                return true;
            }
            else if(id == R.id.nav_more) {
                Toast.makeText(this, "clicked more", Toast.LENGTH_SHORT).show();
                return true;
            }
            else
                return false;

    }



}