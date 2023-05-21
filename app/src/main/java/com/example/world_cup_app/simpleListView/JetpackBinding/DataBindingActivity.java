package com.example.world_cup_app.simpleListView.JetpackBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.world_cup_app.R;
import com.example.world_cup_app.databinding.ActivityDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity {

    private ActivityDataBindingBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding);

        Person person1 = new Person("Kamakshi", "lavitaranatarana@gmail.com");
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        dataBinding.setPerson(person1);
    }
}
