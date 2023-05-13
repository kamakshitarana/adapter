package com.example.world_cup_app.simpleListView.BottomNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.world_cup_app.R;
import com.example.world_cup_app.simpleListView.NavigationDrawer.FirstFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomActivity extends AppCompatActivity implements
        NavigationBarView.OnItemSelectedListener {


    BottomNavigationView bottomNavigationView;
    FirsstFragment firsstFragment =new FirsstFragment();
    SeconddFragment seconddFragment =new SeconddFragment();
    ThriddFragment thriddFragment =new ThriddFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        bottomNavigationView =findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.profile) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flfragment,firsstFragment).commit();
            return true;
        } else if (item.getItemId() == R.id.home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flfragment,seconddFragment).commit();
            return true;
        } else if (item.getItemId() == R.id.settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flfragment,thriddFragment).commit();
            return true;
        } else {
            return false;
        }
    }


}