package com.example.fragmentwithnavigationcomponent.UI;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.fragmentwithnavigationcomponent.Model.User;
import com.example.fragmentwithnavigationcomponent.Util.AlertBox;
import com.example.fragmentwithnavigationcomponent.R;

import static androidx.core.content.ContextCompat.checkSelfPermission;

public class Fragment_Registration extends Fragment implements
        View.OnClickListener,
        AdapterView.OnItemSelectedListener,
        RadioGroup.OnCheckedChangeListener {

    public static final String CLASSTAG = Fragment_Login.class.getSimpleName();
    private static final int PERMISSION_READ_STATE = 1;

    private EditText mFirstName;
    private EditText mPhoneNumber;
    private EditText mChoosePassword;
    private EditText mConfirmPassword;
    private EditText mAdhar;
    private RadioGroup mRadioGroup;
    private Spinner mSpinCountry;
    private Spinner mSpinState;
    private EditText mImei;
    private Button mBtnSignUp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        mFirstName = view.findViewById(R.id.Name);
        mPhoneNumber = view.findViewById(R.id.Contact);
        mChoosePassword = view.findViewById(R.id.Password);
        mRadioGroup = view.findViewById(R.id.gender);
        mSpinCountry = view.findViewById(R.id.spinner1);
        mSpinState = view.findViewById(R.id.spinner2);
        mConfirmPassword=view.findViewById(R.id.conPassword);
        mAdhar=view.findViewById(R.id.Adhar);
        mImei=view.findViewById(R.id.IMEI);

        mBtnSignUp = view.findViewById(R.id.btn_sign_in);
        mBtnSignUp.setOnClickListener(this);
        bindCountries();
        bindStates();

        mSpinCountry.setOnItemSelectedListener(this);
        mSpinState.setOnItemSelectedListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
        //CheckPermission for Reading the Phone State.
        //Dangerous Permission are restricted by Android and USer can revoke the Permission so generating run time Permission .
        if (checkSelfPermission(this.getActivity(), Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // We do not have this permission. Let's ask the user
            ActivityCompat.requestPermissions(this.getActivity(), new String[]{Manifest.permission.READ_PHONE_STATE}, PERMISSION_READ_STATE);
        }
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();  //Storing the IMEI Number.
        mImei.setText(imei);
        mImei.setEnabled(false);
        mImei.setTextColor(Color.GRAY);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_READ_STATE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission granted!
                    // you may now do the action that requires this permission
                } else {
                    // permission denied
                }
                return;
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void bindCountries(){
        String[] countries=getResources().getStringArray(R.array.countries_array);
        ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, countries);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mSpinCountry.setAdapter(adapterCountry);
    }

    private void bindStates(){
        String[] states=getResources().getStringArray(R.array.states_array);

        ArrayAdapter<String> adapterStates = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, states);
        adapterStates.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mSpinState.setAdapter(adapterStates);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_sign_in) {
            onSignUpButtonClick();
        }

    }

    private void onSignUpButtonClick(){
        if(isValid()){
            NavController navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
            navController.navigate(R.id.action_fragment_Registration_to_fragment_Login);
            alert();
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     * check if all the data is field
     * @return boolean
     */
    private boolean isValid() {
        if (TextUtils.isEmpty(mFirstName.getText().toString())) {
            new AlertBox().showAlert(getActivity(),"Please Enter Username");
            return false;
        }
        if (TextUtils.isEmpty(mPhoneNumber.getText().toString())) {
            new AlertBox().showAlert(getActivity(),"Please Enter Phone Number");
            return false;
        }else{
            if(mPhoneNumber.getText().toString().length()!=10)
            {
                new AlertBox().showAlert(getActivity(),"Please Check your phone number");
                return false;
            }
        }

        if (TextUtils.isEmpty(mChoosePassword.getText().toString())) {

            new AlertBox().showAlert(getActivity(),"Please Enter Password");
            return false;
        }


        if(TextUtils.isEmpty(mAdhar.getText().toString())){
            mAdhar.requestFocus();
        }
        if(!TextUtils.isEmpty(mConfirmPassword.getText().toString())){
            if(mChoosePassword.getText().toString().equals(mConfirmPassword.getText().toString())){
                return true;
            }else{
                new AlertBox().showAlert(getActivity(),"Please Password Not Matched");
                return false;
            }
        }
        return true;
    }

    /***
     * To Display Information
     */
    public void alert(){
        User user=new User();
        user.setFirstName(mFirstName.getText().toString().trim());
        user.setPhoneNumber(mPhoneNumber.getText().toString().trim());
        user.setGender(mRadioGroup.toString());
        user.setCountry(mSpinCountry.toString());
        user.setState(mSpinState.toString());

      AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
        builder.setMessage("Details Filled \n Name: " + user.getFirstName()+" \n Contact number:\n" + user.getPhoneNumber());
        builder.setTitle("Information!");

        builder.setCancelable(false);

        builder
                .setPositiveButton(
                        "Okay",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();

    }
}