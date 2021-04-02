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

import com.glencconnnect.net1.AboutActivity;
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
    private String dial_pay;

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

        payments.setOnClickListener(view1 -> {
            dial_pay = DialCodes.more_dialcodes[0];
            //call universalDialer from mainactivity and pass in the code
            mainActivity.universalDial(dial_pay);
            mainActivity.dialIntent();
        });
        obb.setOnClickListener(view1 -> {

            dial_pay = DialCodes.more_dialcodes[1];
            mainActivity.universalDial(dial_pay);
        });
        about.setOnClickListener(view1 -> {
            startActivity(new Intent(getActivity(), AboutActivity.class));
        });
        terms.setOnClickListener(view1 -> {
            String url = "https://www.netone.co.zw/support";
            Intent urlIntent = new Intent(Intent.ACTION_VIEW);
            urlIntent.setData(Uri.parse(url));
            startActivity(urlIntent);
        });
        shareApp.setOnClickListener(view1 -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT,"use our all in one netone app for your convenience");
            startActivity(Intent.createChooser(shareIntent,"share netOne app"));

        });



        return view;
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