package com.glencconnnect.net1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.glencconnnect.net1.fragments.ContactsFragment;
import com.glencconnnect.net1.fragments.HomeFragment;
import com.glencconnnect.net1.fragments.MoreFragment;
import com.glencconnnect.net1.fragments.OneMoneFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private Toolbar toolbar;
    private TextView titleText;

    public static final String HOMESTART_FRAGMENT_TAG = "com.glencconnect.com.home_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //toolbar title text
        titleText = findViewById(R.id.title_text);


        //bottom navigation setup
        bottomNav = findViewById(R.id.bottom_nav);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //call and return bottom navigation value
               return bottomNavItemSelected(item);
            }
        });

        HomeFragment savedHomeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag(HOMESTART_FRAGMENT_TAG);

        //create new fragment if there is no existing one
        if(savedHomeFragment == null) {
            //load home fragment on activity create
            HomeFragment homeFragment = new HomeFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.main_holder_fragment, homeFragment, HOMESTART_FRAGMENT_TAG);
//            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

    }

    //set Title for each fragment
    public void setFragmentTitle(String title){
        titleText.setText(title);
    }

    //choose navigation option and return result as boolean to navigationlistener
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
        fragmentTransaction.replace(R.id.main_holder_fragment,fragment);
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}