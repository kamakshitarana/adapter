package com.example.world_cup_app.simpleListView.SharedPref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.world_cup_app.R;

public class SharedprefActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpref);

        editText =findViewById(R.id.editText);
        textView =findViewById(R.id.textview);
        button =findViewById(R.id.button);

        DisplaySaveText();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1- first getting the data from the edittext when user click button
                String enteredText =editText.getText().toString();
                DisplayAndSaveText(enteredText);
            }
        });
    }

    private void DisplaySaveText() {
        //Retrieving the value from sharedpref
        SharedPreferences sharedPreferences=
                getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s1 =sharedPreferences.getString("name"," ");
        textView.setText(s1);


    }

    private void DisplayAndSaveText(String enteredText) {
        //2- display the text
        textView.setText(enteredText);

        //saving the text into sharedPref
        SharedPreferences sharedPreferences=getSharedPreferences
                ("MySharedPref",MODE_PRIVATE);

        //writing data to shared pref
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //
        editor.putString("name" ,enteredText);
        editor.commit();


    }
}