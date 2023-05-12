package com.example.world_cup_app.simpleListView.TabLayout;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.world_cup_app.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class MyTabLayoutActivity extends AppCompatActivity {

    TabItem tabchat,tabstatus,tabcals;
    ViewPager viewPager;
    TabLayout tabLayoutview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        tabLayoutview = findViewById(R.id.tabLayout);
        tabcals= findViewById(R.id.calls);
        tabstatus= findViewById(R.id.status);
        tabchat= findViewById(R.id.chat);
        viewPager =findViewById(R.id.viewPager);

        MyPagerAdapterr pagerAdapter = new MyPagerAdapterr(getSupportFragmentManager(), 3);
        viewPager.setAdapter(pagerAdapter);

            //used to join the tablayout with viewpager
            tabLayoutview.setupWithViewPager(viewPager);
    }
}