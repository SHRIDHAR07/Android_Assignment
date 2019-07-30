package com.example.mycounter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private EditText name;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = findViewById(R.id.btn_sign_up);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        name =findViewById(R.id.et_Name);
        password=findViewById(R.id.et_password);
        switch (view.getId()) {
            case R.id.btn_sign_up:

                    Intent intent=new Intent(this,CounterActivity.class);
                    startActivity(intent);

            break;
        }
    }
}




