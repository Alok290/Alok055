package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignUp extends AppCompatActivity {
    EditText t4,t5,t6,t7;
    Button b1;
    CountryCodePicker ccp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        t4 = (EditText) findViewById(R.id.name_SignUp);
        t5 = (EditText) findViewById(R.id.email_SignUp);
        t6 = (EditText) findViewById(R.id.phone_SignUp);
        t7 = (EditText) findViewById(R.id.pwd_SignUp);
        b1 = (Button) findViewById(R.id.b1);
        ccp= (CountryCodePicker) findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(t6);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SignUp.this,otpPage.class);
                intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace("","" ));
                startActivity(intent);
            }
        });



    }


}