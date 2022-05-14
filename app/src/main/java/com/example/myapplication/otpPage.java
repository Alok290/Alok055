package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class otpPage extends AppCompatActivity {
    EditText t8;
    Button b2;
    String phoneNumber;
   FirebaseAuth mAuth;
    String otpId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_page);

        mAuth = FirebaseAuth.getInstance();


        phoneNumber = getIntent().getStringExtra("mobile").toString();
        t8 = (EditText) findViewById(R.id.otp);
        b2 = (Button) findViewById(R.id.b2);

        InitiateOtp();

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(t8.getText().toString().isEmpty()){
                    Toast.makeText(otpPage.this, "Empty field", Toast.LENGTH_SHORT).show();
                }
                else if(t8.getText().toString().length()!=6){
                    Toast.makeText(otpPage.this, "Invalid otp", Toast.LENGTH_SHORT).show();

                }
                else{
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otpId,t8.getText().toString());
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });

    }

    private void InitiateOtp() {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                                otpId=s;
                            }

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                signInWithPhoneAuthCredential(phoneAuthCredential);

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(otpPage.this, "Failed", Toast.LENGTH_SHORT).show();

                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(otpPage.this,MainHome.class));
                            finish();

                        }
                        else {
                            Toast.makeText(otpPage.this, "SignIN code error", Toast.LENGTH_SHORT).show();

                            }
                        }

                });
    }
}