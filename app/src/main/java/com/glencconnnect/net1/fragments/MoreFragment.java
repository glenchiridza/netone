package com.glencconnnect.net1.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.glencconnnect.net1.MainActivity;
import com.glencconnnect.net1.R;
import com.glencconnnect.net1.models.DialCodes;


public class MoreFragment extends Fragment {

    private static final int PHONECALL_REQUESTCODE = 12;
    private CardView payments;
    private CardView obb;
    private CardView about;
    private CardView terms;
    private CardView shareApp;
    private MainActivity mainActivity;
    private String[] phonePermission;
    private String dial;

    public MoreFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout
        View view = inflater.inflate(R.layout.fragment_more, container, false);


        //initialize views
        init(view);

        phonePermission = new String[]{Manifest.permission.CALL_PHONE,Manifest.permission.READ_PHONE_STATE};


        mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.setFragmentTitle("More Options");

        //load dial codes
        dial = DialCodes.dialcodes[0];

        payments.setOnClickListener(view1 -> {
            dialIntent();
        });
        obb.setOnClickListener(view1 -> {

        });
        about.setOnClickListener(view1 -> {

        });
        terms.setOnClickListener(view1 -> {

        });
        shareApp.setOnClickListener(view1 -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT,"use our all in one netone app for your convenience");
            startActivity(Intent.createChooser(shareIntent,"share netOne app"));

        });



        return view;
    }

    //handle calls intent
    private void dialIntent(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.fromParts("tel",dial,null));
//</ setup form >
//< check: phone permission >
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
        ActivityCompat.requestPermissions(getActivity(),phonePermission,PHONECALL_REQUESTCODE);
    }

    private boolean permissionGranted() {
        boolean result,result1;

        result = ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED;
        result1 = ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.READ_PHONE_STATE)== PackageManager.PERMISSION_GRANTED;

        return result && result1;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PHONECALL_REQUESTCODE: {
                if (grantResults.length > 0) {
                    boolean phoneAccept = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean phone_read = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if (phoneAccept && phone_read) {
                        dialIntent();
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


    //initialize views
    private void init(View view) {
        payments = view.findViewById(R.id.cardView);
        obb = view.findViewById(R.id.cardView2);
        about = view.findViewById(R.id.cardView3);
        terms = view.findViewById(R.id.cardView4);
        shareApp = view.findViewById(R.id.cardView5);
    }
}