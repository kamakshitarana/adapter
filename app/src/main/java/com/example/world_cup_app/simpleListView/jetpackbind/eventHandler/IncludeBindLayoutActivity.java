package com.example.world_cup_app.simpleListView.jetpackbind.eventHandler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.world_cup_app.R;
import com.example.world_cup_app.databinding.ActivityEmptyHandleBinding;

public class IncludeBindLayoutActivity extends AppCompatActivity {

    private ActivityEmptyHandleBinding activityEmptyHandleBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Personc person =new Personc("Kamakshi");
        setContentView(R.layout.activity_empty_handle);
        activityEmptyHandleBinding = DataBindingUtil.setContentView(this,R.layout
                .activity_empty_handle);
        activityEmptyHandleBinding.setPersonc(person);


    }
}