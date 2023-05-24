package com.example.world_cup_app.simpleListView.jetpackbind.contactManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.world_cup_app.R;
import com.example.world_cup_app.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewContactBinding activityAddNewContactBinding;
    Contact contact;
    private  AddNewContactActivityClickHandler addNewContactActivityClickHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        contact =new Contact();
        activityAddNewContactBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_new_contact);
        activityAddNewContactBinding.setContact(contact);
        addNewContactActivityClickHandler= new AddNewContactActivityClickHandler(this);
        activityAddNewContactBinding.setClickHandler(addNewContactActivityClickHandler);

    }

    public class AddNewContactActivityClickHandler{
        Context context;

        public AddNewContactActivityClickHandler(Context context) {
            this.context = context;
        }

        public void onSubmitClicked(View view){
            if(contact.getName()==null){
                Toast.makeText(getApplicationContext(), "Fields are can not be empty", Toast.LENGTH_SHORT).show();
            }else{
                Intent i =new Intent();
                i.putExtra("NAME",contact.getName());
                i.putExtra("EMAIL",contact.getEmail());


                setResult(RESULT_OK,i);
                finish();
            }
        }




    }
}