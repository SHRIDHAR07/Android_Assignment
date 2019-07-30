package com.example.mycounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity extends AppCompatActivity implements View.OnClickListener {
private TextView textView;
private Button plus;
private Button minus;
private  String result;
private EditText editText;
private Button set_counter1;
int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        plus =findViewById(R.id.btn_plus);
        plus.setOnClickListener(this);
        minus=findViewById(R.id.btn_minus);
        minus.setOnClickListener(this);

        set_counter1= findViewById(R.id.set_counter);
        set_counter1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_plus:
                counter++;
                result= String.valueOf(counter);
                textView=findViewById(R.id.counter);
                textView.setText(result);
                Toast.makeText(this,"Counter Increment ",Toast.LENGTH_LONG).show();
                break;
                case R.id.btn_minus:
                    if(counter==0)
                    {
                        Toast.makeText(this,"Can't Decrement counter  ",Toast.LENGTH_SHORT).show();
                    }else{
                        counter--;
                        textView=findViewById(R.id.counter);
                        result= String.valueOf(counter);
                        textView.setText(result);
                        Toast.makeText(this,"Counter Decrement ",Toast.LENGTH_LONG).show();
                    }
                    break;
            case R.id.set_counter:
                editText=findViewById(R.id.input);
                if(editText!=null){
                    counter=Integer.parseInt(String.valueOf(editText.getText()));
                }
                else{
                    Toast.makeText(this,"Counter Will Start from zero ",Toast.LENGTH_LONG).show();
                }
                break;

        }
    }
}
