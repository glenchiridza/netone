package com.glencconnnect.net1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.glencconnnect.net1.MainActivity;
import com.glencconnnect.net1.R;
import com.glencconnnect.net1.models.DialCodes;


public class HomeFragment extends Fragment {


    private TextView checkBal;
    private TextView topup;
    private TextView payMrchant;
    private TextView zesa;
    private TextView bundles;
    private TextView onefusion;
    private TextView oneFi;
    private TextView call_back;
    private TextView credit_airtime;
    private TextView katsaona;
    private TextView onecover;
    private TextView services;
    private TextView call_center;


    private String dial_code;
    private MainActivity mainActivity;

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //initialize views
        init(view);

        mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.setFragmentTitle("Dashboard");

        //call click listeners
        clickListeners();

        // Inflate the layout
        return view;
    }



    //handle click events for each dial code
    private void clickListeners(){

        checkBal.setOnClickListener(view -> {

            dial_code = DialCodes.one_money_dialcodes[0];
            //call universalDialer from mainactivity and pass in the code
            mainActivity.universalDial(dial_code);
        });

        topup.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[1];
            mainActivity.universalDial(dial_code);
        });

        zesa.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[2];
            mainActivity.universalDial(dial_code);
        });

        payMrchant.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[3];
            mainActivity.universalDial(dial_code);
        });


        bundles.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[4];
            mainActivity.universalDial(dial_code);
        });

        onefusion.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[5];
            mainActivity.universalDial(dial_code);
        });

        oneFi.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[6];
            mainActivity.universalDial(dial_code);
        });

        call_back.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[7];
            mainActivity.universalDial(dial_code);
        });

        credit_airtime.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[8];
            mainActivity.universalDial(dial_code);
        });

        katsaona.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[9];
            mainActivity.universalDial(dial_code);
        });

        onecover.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[10];
            mainActivity.universalDial(dial_code);
        });


        services.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[11];
            mainActivity.universalDial(dial_code);
        });

        call_center.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[12];
            mainActivity.universalDial(dial_code);
        });

        
    }


    public void init(View view){
        checkBal = view.findViewById(R.id.check_balance);
        topup = view.findViewById(R.id.airtime_top_up);
        payMrchant = view.findViewById(R.id.pay_merchant);
        zesa = view.findViewById(R.id.buy_zesa);
        bundles = view.findViewById(R.id.bundles);
        onefusion = view.findViewById(R.id.one_fusion);
        oneFi = view.findViewById(R.id.one_fi);
        call_back = view.findViewById(R.id.call_back);
        credit_airtime = view.findViewById(R.id.credit_airtime);
        katsaona = view.findViewById(R.id.katsaona);
        onecover = view.findViewById(R.id.one_cover);
        services = view.findViewById(R.id.service);
        call_center = view.findViewById(R.id.call_center);
    }
}