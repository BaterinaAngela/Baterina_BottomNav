package com.example.baterina_bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout, new HomeFragment()).commit();
        }

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navHome:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout, new HomeFragment()).commit();
                        break;
                    case R.id.navProfile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout, new ProfileFragment()).commit();
                        break;
                    case R.id.navSettings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout, new SettingsFragment()).commit();
                        break;
                }
                return true;
            }
        });

    }

    private void initComponents() {
        bottomNav = findViewById(R.id.main_bottom_nav);
        frameLayout = findViewById(R.id.main_frameLayout);
    }
}