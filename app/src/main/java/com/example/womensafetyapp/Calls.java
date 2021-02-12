package com.example.womensafetyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.Manifest.permission.CALL_PHONE;

public class Calls extends AppCompatActivity {

    Button b1,b2,b3;
    private static final String AMBULANCE_NUMBER="102";
    private static final String WOMEN_HELPLINE_NUMBER="1091";
    private static final String NATIONAL_EMERGENCY_NUMBER="122";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calls);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call(AMBULANCE_NUMBER);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call(WOMEN_HELPLINE_NUMBER);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Calls.this, "hello", Toast.LENGTH_SHORT).show();
                call(NATIONAL_EMERGENCY_NUMBER);
            }
        });
    }

    private void call(String Number) {
        Intent i =new Intent (Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:"+Number));
        if(ContextCompat.checkSelfPermission(getApplicationContext(),CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
            startActivity(i);
        }
        else {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                requestPermissions(new String[]{CALL_PHONE}, 1);
            }
        }
    }
}