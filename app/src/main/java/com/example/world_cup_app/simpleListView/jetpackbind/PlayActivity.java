package com.example.world_cup_app.simpleListView.jetpackbind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.world_cup_app.R;
import com.example.world_cup_app.databinding.ActivityDataBindingBinding;

public class PlayActivity extends AppCompatActivity {

    private ActivityDataBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding);

        Person person1 = new Person("Kamakshi", "lavitaranatarana@gmail.com");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        binding.setPerson(person1);
    }
}
