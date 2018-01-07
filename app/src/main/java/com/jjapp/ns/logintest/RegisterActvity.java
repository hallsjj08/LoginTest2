package com.jjapp.ns.logintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class RegisterActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_actvity);

        EditText etFirst = (EditText) findViewById(R.id.etFirst);
        EditText etLast = (EditText) findViewById(R.id.etLast);
        EditText etEIN = (EditText) findViewById(R.id.etEIN);
        EditText etRacfID = (EditText) findViewById(R.id.etRac);
    }
}
