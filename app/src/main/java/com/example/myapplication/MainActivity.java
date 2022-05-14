package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2,t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);
        t3 = findViewById(R.id.text3);

    }

    public void SignUpHere(View view) {

            startActivity(new Intent(MainActivity.this, SignUp.class));

    }

    public void SignInHere(View view) {
        startActivity(new Intent(MainActivity.this, MainActivity2.class));

    }

    public void Skip(View view) {
        startActivity(new Intent(MainActivity.this,MainHome.class));
    }
}