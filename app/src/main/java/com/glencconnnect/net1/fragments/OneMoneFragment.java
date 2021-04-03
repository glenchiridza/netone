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

public class OneMoneFragment extends Fragment {


    private TextView checkBal;
    private TextView topup;
    private TextView payMrchant;
    private TextView zesa;
    private TextView sendMoney;
    private TextView zipit;
    private TextView bundles;
    private TextView onefusion;
    private TextView oneFi;
    private TextView fees;
    private TextView cashout;
    private TextView paybill;
    private TextView banking;
    private TextView language;
    private TextView services;
    private TextView social;
    private TextView sms;
    private TextView others;

    private String dial_code;
    private MainActivity mainActivity;

    public OneMoneFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one_mone, container, false);

        //initialize views
        init(view);

        mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.setFragmentTitle("One Money");

        //click listeners
        clickListeners();

        //return Inflated the layout
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

        sendMoney.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[4];
            mainActivity.universalDial(dial_code);
        });

        zipit.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[5];
            mainActivity.universalDial(dial_code);
        });

        bundles.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[6];
            mainActivity.universalDial(dial_code);
        });

        onefusion.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[7];
            mainActivity.universalDial(dial_code);
        });

        oneFi.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[8];
            mainActivity.universalDial(dial_code);
        });

        fees.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[9];
            mainActivity.universalDial(dial_code);
        });

        cashout.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[10];
            mainActivity.universalDial(dial_code);
        });

        paybill.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[11];
            mainActivity.universalDial(dial_code);
        });

        banking.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[12];
            mainActivity.universalDial(dial_code);
        });

        language.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[13];
            mainActivity.universalDial(dial_code);
        });

        services.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[14];
            mainActivity.universalDial(dial_code);
        });

        social.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[15];
            mainActivity.universalDial(dial_code);
        });

        sms.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[16];
            mainActivity.universalDial(dial_code);
        });

        others.setOnClickListener(view -> {
            dial_code = DialCodes.one_money_dialcodes[17];
            mainActivity.universalDial(dial_code);
        });
    }


    public void init(View view){
        checkBal = view.findViewById(R.id.check_balance);
        topup = view.findViewById(R.id.airtime_top_up);
        payMrchant = view.findViewById(R.id.pay_merchant);
        zesa = view.findViewById(R.id.buy_zesa);
        sendMoney = view.findViewById(R.id.send_money);
        zipit = view.findViewById(R.id.zipit);
        bundles = view.findViewById(R.id.bundles);
        onefusion = view.findViewById(R.id.one_fusion);
        oneFi = view.findViewById(R.id.one_fi);
        fees = view.findViewById(R.id.school_fees);
        cashout = view.findViewById(R.id.cash_out);
        paybill = view.findViewById(R.id.pay_bill);
        banking = view.findViewById(R.id.banking);
        language = view.findViewById(R.id.language);
        services = view.findViewById(R.id.services);
        social = view.findViewById(R.id.social_media);
        sms = view.findViewById(R.id.sms_bundle);
        others = view.findViewById(R.id.others);
    }
}
