package com.glencconnnect.net1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.glencconnnect.net1.fragments.ContactsFragment;
import com.glencconnnect.net1.fragments.HomeFragment;
import com.glencconnnect.net1.fragments.MoreFragment;
import com.glencconnnect.net1.fragments.OneMoneFragment;
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
               return bottomNavItemSelected(item);
            }
        });

    }

    private boolean bottomNavItemSelected(MenuItem item) {
       int id = item.getItemId();
            if(id == R.id.nav_home){
                HomeFragment homeFragment = new HomeFragment();
                setUpFragment(homeFragment);
                Toast.makeText(this, "clicked home", Toast.LENGTH_SHORT).show();
                return true;

            }

            else if(id == R.id.nav_one_money){
                OneMoneFragment oneMoneFragment = new OneMoneFragment();
                setUpFragment(oneMoneFragment);
                Toast.makeText(this, "clicked money", Toast.LENGTH_SHORT).show();
                return true;
            }

            else if(id == R.id.nav_contacts){

                ContactsFragment contactsFragment = new ContactsFragment();
                setUpFragment(contactsFragment);
                Toast.makeText(this, "clicked contact", Toast.LENGTH_SHORT).show();

                return true;
            }
            else if(id == R.id.nav_more) {
                MoreFragment moreFragment = new MoreFragment();
                setUpFragment(moreFragment);
                Toast.makeText(this, "clicked more", Toast.LENGTH_SHORT).show();
                return true;
            }
            else
                return false;

    }


    public void setUpFragment(Fragment fragment){
//        fragment = new Fragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}