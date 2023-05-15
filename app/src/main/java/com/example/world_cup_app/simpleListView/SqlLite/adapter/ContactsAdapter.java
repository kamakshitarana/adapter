package com.example.world_cup_app.simpleListView.SqlLite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.world_cup_app.R;
import com.example.world_cup_app.simpleListView.SqlLite.SqlLiteActivity;
import com.example.world_cup_app.simpleListView.SqlLite.db.entity.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    // 1- Variable
    private Context context;
    private ArrayList<Contact> contactsList;
    private SqlLiteActivity sqlLiteActivity;

    // 2- ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.email = itemView.findViewById(R.id.email);
        }
    }

    public ContactsAdapter(Context context, ArrayList<Contact> contacts, SqlLiteActivity sqlLiteActivity){
        this.context = context;
        this.contactsList = contacts;
        this.sqlLiteActivity = sqlLiteActivity;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.contact_list_item,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Contact contact = contactsList.get(position);
        holder.name.setText(contact.getName());
        holder.email.setText(contact.getEmail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlLiteActivity.addAndEditContacts(true,contact,position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return contactsList.size();
    }
}
