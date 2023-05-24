package com.example.world_cup_app.simpleListView.jetpackbind.contactManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.example.world_cup_app.R;
import com.example.world_cup_app.databinding.ActivityContactManagerBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ContactManagerActivity extends AppCompatActivity {

    private  ContactAppDatabase contactAppDatabase;
    private ArrayList<Contact> contacts;
    private ContactDataAdapter contactDataAdapter;

    //Binding
    private ActivityContactManagerBinding activityContactManagerBinding;
    private ContactManagerActivityClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_manager);
        // Initialize contacts ArrayList
        contacts = new ArrayList<>();

        //data binding handler
        activityContactManagerBinding = DataBindingUtil.setContentView(this,R.layout.activity_contact_manager);
        handlers =new ContactManagerActivityClickHandlers(this);
        activityContactManagerBinding.setClickHandler(handlers);

        //RecylerView
        RecyclerView recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //Adapter
        contactDataAdapter = new ContactDataAdapter(contacts);
        recyclerView.setAdapter(contactDataAdapter);

        //DataBase
        contactAppDatabase =Room.databaseBuilder(
                getApplicationContext(),
                ContactAppDatabase.class,
                "ContactDB"

        )
                .fallbackToDestructiveMigration() // Add this line
                .build();

        //Add Data
        LoadData();

        //handling swipping
        new ItemTouchHelper(new ItemTouchHelper.Callback() {

            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView,
                                        @NonNull RecyclerView.ViewHolder viewHolder) {
                return 0;
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder,
                                 int direction) {
                Contact contact =contacts.get(viewHolder.getAdapterPosition());
                DeleteContact(contact);
            }
        }).attachToRecyclerView(recyclerView);


        //FAB
//        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(ContactManagerActivity.this,AddNewContactActivity.class);
//                startActivityForResult(i,1);
//            }
//        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1 && resultCode == RESULT_OK){
            String name = data.getStringExtra("NAME");
            String email = data.getStringExtra("EMAIL");
            Contact contact =new Contact(name,email,0);
            AddNewContact(contact);

        }
    }

    private void DeleteContact(Contact contact) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler =new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //ONBackground
                contactAppDatabase.getContactDAO().delete(contact);
                contacts.remove(contact);

                //On postExecute
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        contactDataAdapter.notifyDataSetChanged();

                    }
                });

            }
        });


    }

    private void LoadData() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler =new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //ONBackground
                contacts.addAll(contactAppDatabase.getContactDAO().getAllContacts());
                //On postExecute
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        contactDataAdapter.setContacts(contacts);
                        contactDataAdapter.notifyDataSetChanged();

                    }
                });

            }
        });

    }

    private void AddNewContact(Contact contact){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler =new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //ONBackground
                contactAppDatabase.getContactDAO().insert(contact);
                //On postExecute
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        contactDataAdapter.notifyDataSetChanged();

                    }
                });

            }
        });

    }

    public class ContactManagerActivityClickHandlers{
        Context context;

        public ContactManagerActivityClickHandlers(Context context) {
            this.context = context;
        }
        public void onFABClicked(View view){
            Intent i =new Intent(ContactManagerActivity.this,AddNewContactActivity.class);
            startActivityForResult(i,1);
        }
    }

}