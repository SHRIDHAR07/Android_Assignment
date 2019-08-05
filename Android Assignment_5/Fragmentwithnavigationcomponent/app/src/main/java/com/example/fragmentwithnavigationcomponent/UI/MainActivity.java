package com.example.fragmentwithnavigationcomponent.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.fragmentwithnavigationcomponent.R;

public class MainActivity extends AppCompatActivity {

    private static int splash_time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Authentication.class);
                //Intent is used to switch from one activity to another.

                startActivity(intent);
                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, splash_time);
    }


}
