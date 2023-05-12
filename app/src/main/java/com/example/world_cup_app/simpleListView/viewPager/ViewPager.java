package com.example.world_cup_app.simpleListView.viewPager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.world_cup_app.R;

public class ViewPager extends AppCompatActivity {

    androidx.viewpager.widget.ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager =findViewById(R.id.view_pager);
        MyPagerAdapter myPagerAdapter =new MyPagerAdapter(this);

        viewPager.setAdapter(myPagerAdapter);
    }
}