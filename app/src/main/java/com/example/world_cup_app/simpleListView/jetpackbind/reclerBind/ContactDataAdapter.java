package com.example.world_cup_app.simpleListView.jetpackbind.reclerBind;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.world_cup_app.R;
import com.example.world_cup_app.databinding.ContactList2Binding;

import java.util.ArrayList;

public class ContactDataAdapter extends RecyclerView.Adapter<ContactDataAdapter.ContactViewHolder> {


    private ArrayList<Contact> contacts;


    public ContactDataAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).
//                inflate(R.layout.contact_list_item,parent, false);
//        return new ContactViewHolder(itemView);

        ContactList2Binding contactListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.contact_list_item, parent, false);

        return new ContactViewHolder(contactListItemBinding);

    }


    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int i) {
        Contact currentContact = contacts.get(i);
//        holder.name.setText(currentContact.getName());
//        holder.email.setText(currentContact.getEmail());


        holder.contactListItemBinding.setContact(currentContact);

    }

    @Override
    public int getItemCount() {
        if (contacts != null){
            return contacts.size();
        }else{
            return 0;
        }

    }

    public void setContacts(ArrayList<Contact> contacts){
        this.contacts = contacts;
        notifyDataSetChanged();
    }


    class ContactViewHolder extends RecyclerView.ViewHolder{

        private ContactList2Binding contactListItemBinding;

        //private TextView name, email;

        public ContactViewHolder(@NonNull ContactList2Binding contactListItemBinding) {
            super(contactListItemBinding.getRoot());

            this.contactListItemBinding = contactListItemBinding;

//            this.name = itemView.findViewById(R.id.tvName);
//            this.email = itemView.findViewById(R.id.tvEmail);
        }
    }


}
