package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;


public class MainHome extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new HomeFragment()).commit();

        bottomNavigationView.setSelectedItemId(R.id.nav_Home);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
              switch (item.getItemId()){

                  case R.id.nav_Home:
                      fragment = new HomeFragment();
                              break;

                  case R.id.nav_Category:
                      fragment = new CategoryFragment();
                      break;

                  case R.id.nav_search:
                      fragment = new SearchFragment();
                      break;

                  case R.id.nav_Cart:
                      fragment = new CartFragment();
                      break;

                  case R.id.nav_Menu:
                      fragment = new MenuFragment();
                      break;
              }
               getSupportFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();

                return true;
            }
        });
    }
}