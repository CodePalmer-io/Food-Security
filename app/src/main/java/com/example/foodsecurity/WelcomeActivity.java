package com.example.foodsecurity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_history:
                        startActivity(new Intent(getApplicationContext(), History.class));

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_person:
                        startActivity(new Intent(getApplicationContext(), Profile.class));

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_home:

                        return true;
                }
                return false;
            }
        });
    }
}
