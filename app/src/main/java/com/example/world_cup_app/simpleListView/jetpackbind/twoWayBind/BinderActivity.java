package com.example.world_cup_app.simpleListView.jetpackbind.twoWayBind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.world_cup_app.R;
import com.example.world_cup_app.databinding.ActivityBinderBinding;

public class BinderActivity extends AppCompatActivity {

    private ActivityBinderBinding activityBinderBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder);

        //first way of dataBinding
        Persoon persoon =new Persoon("Kamakshi");
        activityBinderBinding = DataBindingUtil.setContentView(this,R.layout.activity_binder);
        activityBinderBinding.setPersoon(persoon);


    }
}