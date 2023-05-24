package com.example.world_cup_app.simpleListView.jetpackbind.contactManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.world_cup_app.R;

import java.util.ArrayList;
import java.util.List;

public class ContactDataAdapter extends RecyclerView.Adapter<ContactDataAdapter.ContactviewHolder> {

    private ArrayList<Contact> contacts;

    public ContactDataAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.contact_list,parent,false);
        return new ContactviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactviewHolder holder, int i) {
      Contact currentcontact=contacts.get(i);
      holder.name.setText(currentcontact.getName());
      holder.email.setText(currentcontact.getEmail());
    }

    @Override
    public int getItemCount() {
        if (contacts!=null){
            return contacts.size();
        }else {
            return 0;
        }
    }
    public void setContacts(ArrayList<Contact> contacts){
        this.contacts=contacts;
        notifyDataSetChanged();
    }

    class ContactviewHolder extends RecyclerView.ViewHolder{
        private TextView name,email;

       public ContactviewHolder(@NonNull View itemView){
           super(itemView);
           this.name =itemView.findViewById(R.id.tvName);
           this.email =itemView.findViewById(R.id.tvEmail);
       }


    }

}
