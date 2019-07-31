package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] states  = { "Maharashtra","Gujarat","Goa","Delhi","Jharkhand" };
    String[] districts={"Nashik","Mumbai","Delhi"};
    String[] grampanchayat ={"New Nashik","Navi Mumbai "};
    String[] village={"Uran","Panvel"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        // Drop Down list for states
        Spinner spin =findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, states);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
        // Drop Down List for Districts
        Spinner spin1 =findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, districts);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adapter1);
        spin1.setOnItemSelectedListener(this);

        Spinner spin2 =findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, grampanchayat);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter2);
        spin2.setOnItemSelectedListener(this);

        Spinner spin3 =findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, village);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(adapter3);
        spin3.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(), "Selected is "+states[position] , Toast.LENGTH_SHORT).show();
        if(R.id.spinner2==1){
            Toast.makeText(getApplicationContext(), "Selected is "+districts[position] , Toast.LENGTH_SHORT).show();
        }
        if (R.id.spinner3==1){
            Toast.makeText(getApplicationContext(), "Selected is "+grampanchayat[position] , Toast.LENGTH_SHORT).show();
        }
        if(R.id.spinner3==1){
            Toast.makeText(getApplicationContext(), "Selected is "+village[position] , Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
