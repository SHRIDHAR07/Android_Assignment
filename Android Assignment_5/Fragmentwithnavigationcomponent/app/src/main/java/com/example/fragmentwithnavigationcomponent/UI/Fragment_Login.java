package com.example.fragmentwithnavigationcomponent.UI;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.fragmentwithnavigationcomponent.R;
public class Fragment_Login extends Fragment implements View.OnClickListener {
    private EditText mUserName;
    private EditText mPassword;
    private Button mBtnLogin;
    private Button mBtnSignUp;
    private ImageButton mshowpass;
    private Boolean isClicked = false;
    public static final String CLASSTAG = Fragment_Login.class.getSimpleName();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Initialise all the members which are needed for the login screen
     *
     * @param view
     */
    private void initView(View view) {
        mUserName = view.findViewById(R.id.Contact_Sign_in);
        mPassword = view.findViewById(R.id.Password_sign_in);
        mBtnLogin = view.findViewById(R.id.btn_sign_in);
        mBtnSignUp = view.findViewById(R.id.btn_Register);
        mshowpass = view.findViewById(R.id.btn_showPass);

        mBtnLogin.setOnClickListener(this);
        mBtnSignUp.setOnClickListener(this);
        mshowpass.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_in:
                onLoginButtonClick();
                break;

            case R.id.btn_Register:
                onSignUpButtonClick();
                break;
            case R.id.btn_showPass:
                showPass();
                break;
            default:
                break;
        }
    }

    private void showPass() {
        if (isClicked) {
            mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            mshowpass.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.invisible));

        } else {
            mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            mshowpass.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.visible));
        }
        isClicked = !isClicked;

    }


    private void onSignUpButtonClick() {
        NavController navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
        navController.navigate(R.id.action_fragment_Login_to_fragment_Registration);
    }

    private void onLoginButtonClick() {
        if (isValid()) {
            if (mUserName.getText().toString().equals("123") && mPassword.getText().toString().equals("123")){
                Toast.makeText(getActivity(), R.string.login_succ, Toast.LENGTH_SHORT).show();
                NavController navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
                navController.navigate(R.id.action_fragment_Login_to_fragment_Home);
            }

            else
                Toast.makeText(getActivity(), R.string.valid, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValid() {
        if (TextUtils.isEmpty(mUserName.getText().toString())) {
            mUserName.requestFocus();
            mUserName.setError("Please Enter username ");
            return false;
        }

        if (TextUtils.isEmpty(mPassword.getText().toString())) {
            mPassword.requestFocus();
            mPassword.setError("please enter password ");
            return false;
        }


        return true;
    }
}
