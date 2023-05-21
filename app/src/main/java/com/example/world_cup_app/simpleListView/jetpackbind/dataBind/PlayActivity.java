package com.example.world_cup_app.simpleListView.jetpackbind.dataBind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.world_cup_app.R;
import com.example.world_cup_app.databinding.ActivityDataBindingBinding;

public class PlayActivity extends AppCompatActivity {

    private ActivityDataBindingBinding activityDataBindingBinding;
    private PlayActivityClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding);

        Person person1 = new Person("Kamakshi", "lavitaranatarana@gmail.com");

        // Binding the layout
        activityDataBindingBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_data_binding);

        // Set the person object
        activityDataBindingBinding.setPerson(person1);

        // Set the click handler
        clickHandler = new PlayActivityClickHandler(this);
    }

public class PlayActivityClickHandler {
        Context context;

        public PlayActivityClickHandler(Context context){
            this.context =context;
        }
        //first button click handler
        public void onButtonClick(View view){
            Toast.makeText(context, "Hello My Friends", Toast.LENGTH_SHORT).show();
        }

        //second button click handling
        public void onButtonClick2(View view){
            Toast.makeText(context, "Bye bye My Friends", Toast.LENGTH_SHORT).show();
        }


    }

}
