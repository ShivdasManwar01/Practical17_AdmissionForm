package com.example.practical17_admissionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity {

    TextView name,phoneno,email,percentage,c_lass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();

        Intent intent=getIntent();
        name.setText(intent.getStringExtra("name"));
        phoneno.setText(intent.getStringExtra("phoneno"));
        email.setText(intent.getStringExtra("email"));
        c_lass.setText(intent.getStringExtra("c_lass"));
        percentage.setText(intent.getStringExtra("percentage"));
    }
    public void init(){
        name=findViewById(R.id.name);
        phoneno=findViewById(R.id.phoneno);
        email=findViewById(R.id.email);
        percentage=findViewById(R.id.percentage);
        c_lass=findViewById(R.id.c_lass);
    }
}