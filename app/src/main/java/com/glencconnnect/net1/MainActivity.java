package com.glencconnnect.net1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.glencconnnect.net1.fragments.ContactsFragment;
import com.glencconnnect.net1.fragments.HomeFragment;
import com.glencconnnect.net1.fragments.MoreFragment;
import com.glencconnnect.net1.fragments.OneMoneFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final int DIAL_REQUESTCODE = 13;
    private BottomNavigationView bottomNav;
    private Toolbar toolbar;
    private TextView titleText;

    public static final String HOMESTART_FRAGMENT_TAG = "com.glencconnect.com.home_fragment";
    private String[] phonePermission;
    private String dial_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //toolbar title text
        titleText = findViewById(R.id.title_text);

        //permission
        phonePermission = new String[]{Manifest.permission.CALL_PHONE,Manifest.permission.READ_PHONE_STATE};


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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_star){
            startActivity( new Intent(MainActivity.this, MyCodesActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }


    ///calling content

    public void universalDial(String code){
        dial_code = code;
        dialIntent();
    }

    //handle calls intent
    private void dialIntent(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.fromParts("tel",dial_code,null));

//check: phone permission
        if (permissionGranted()) {
// TODO: Consider calling
            requestPhonePermission();

            startActivity(intent);
            return;
        }
//check: phone permission

//call the telephone number
        startActivity(intent);
    }



    private void requestPhonePermission() {
        ActivityCompat.requestPermissions(this,phonePermission, DIAL_REQUESTCODE);
    }

    private boolean permissionGranted() {
        boolean result,result1;

        result = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED;
        result1 = ContextCompat.checkSelfPermission(this,Manifest.permission.READ_PHONE_STATE)== PackageManager.PERMISSION_GRANTED;

        return result && result1;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case DIAL_REQUESTCODE: {
                if (grantResults.length > 0) {
                    boolean phoneAccept = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean phone_read = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if (phoneAccept && phone_read) {
//                        dialIntent();
                    }
                } else {
                    requestPhonePermission();
                }
            }
            break;
            default:return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}