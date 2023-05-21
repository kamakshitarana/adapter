package com.example.world_cup_app.simpleListView.RoomDb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.world_cup_app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoomDbActivity extends AppCompatActivity {

// ROOM Database Project


    // Variables
    private ContactsAdapterrr contactsAdapter;
    private ArrayList<Contacts> contactArrayList  = new ArrayList<>();
    private RecyclerView recyclerView;
    private ContactsAppDatabase contactsAppDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_db);

        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbaar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Favorite Contacts");


        // RecyclerVIew
        recyclerView = findViewById(R.id.recycler_view_contacts);

        //callBacks
        RoomDatabase.Callback myCallBack =new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                //this method will execute when database has been created
                super.onCreate(db);
                //these are 4 contacts already created in the app when installed (Built-in contact)

                CreateContact("KamakshiTarana","Kamakshitarana9058@gmail.com");
                CreateContact("RiyaTarana","riyatarana9058@gmail.com");
                CreateContact("LaviTarana","lavitarana9058@gmail.com");
                CreateContact("KukkeyTarana","Kukkeytarana9058@gmail.com");
                Log.i("TAG","Database has been create");


            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {   //this method will execute when database has been open
                super.onOpen(db);
                Log.i("TAG","Database has been open");

            }
        };




        // Database
        contactsAppDatabase = Room.databaseBuilder(
                        getApplicationContext(),
                        ContactsAppDatabase.class,
                        "ContactDB")
                .addCallback(myCallBack)
                .build();

        // Displaying All Contacts List
//        contactArrayList.addAll(contactsAppDatabase.getContactDAO().getContacts());
        DisplayAllContactInBackground();



        contactsAdapter = new ContactsAdapterrr(this, contactArrayList,RoomDbActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(contactsAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAndEditContacts(false, null, -1);
            }
        });
    }

    public void addAndEditContacts(final boolean isUpdated, final Contacts contact, final int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
        View view = layoutInflater.inflate(R.layout.layout_add_contact,null);

        AlertDialog.Builder alerDialogBuilder = new AlertDialog.Builder(RoomDbActivity.this);
        alerDialogBuilder.setView(view);


        TextView contactTitle = view.findViewById(R.id.new_contact_title);
        final EditText newContact = view.findViewById(R.id.name);
        final EditText contactEmail = view.findViewById(R.id.email);

        contactTitle.setText(!isUpdated ? "Add New Contact" : "Edit Contact");


        if (isUpdated && contact != null){
            newContact.setText(contact.getName());
            contactEmail.setText(contact.getEmail());
        }

        alerDialogBuilder.setCancelable(false)
                .setPositiveButton(isUpdated ? "Update" : "Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Delete",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (isUpdated){
                                    DeleteContact(contact, position);
                                }else{
                                    dialogInterface.cancel();
                                }
                            }
                        }
                );

        final AlertDialog alertDialog = alerDialogBuilder.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(newContact.getText().toString())){
                    Toast.makeText(RoomDbActivity.this, "Please Enter a Name", Toast.LENGTH_SHORT).show();

                    return;
                }else{
                    alertDialog.dismiss();
                }

                if (isUpdated && contact != null){
                    UpdateContact(newContact.getText().toString(), contactEmail.getText().toString(),position);

                }else{
                    CreateContact(newContact.getText().toString(), contactEmail.getText().toString());

                }

            }
        });

    }

    private void DeleteContact(Contacts contact, int position) {

        contactArrayList.remove(position);
        contactsAppDatabase.getContactDAO().deleteContact(contact);
        contactsAdapter.notifyDataSetChanged();


    }


    private void UpdateContact(String name, String email, int position){
        Contacts contact = contactArrayList.get(position);

        contact.setName(name);
        contact.setEmail(email);

        contactsAppDatabase.getContactDAO().updateContact(contact);

        contactArrayList.set(position, contact);
        contactsAdapter.notifyDataSetChanged();


    }

    private void CreateContact(String name, String email){

        long id = contactsAppDatabase.getContactDAO()
                .addContact(new Contacts(name, email,0));

        Contacts contact = contactsAppDatabase.getContactDAO().getContact(id);

        if (contact != null){
            contactArrayList.add(0, contact);
            contactsAdapter.notifyDataSetChanged();
        }

    }


    //the below method will execute the when application have ANR error an application not responding

    private void DisplayAllContactInBackground(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler =new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //Background Work
                contactArrayList.addAll(contactsAppDatabase.getContactDAO().getContacts());

                //Executed after the Background work had finished
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //added now in reclyerview
                        contactsAdapter.notifyDataSetChanged();

                    }
                });

            }
        });

    }


    // Menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}