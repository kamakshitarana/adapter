package com.example.world_cup_app.simpleListView.RoomDb;
//(DAO class data access object) database helper class

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDAO {

    @Insert
    public long addContact(Contacts contact);

    @Update
    public void updateContact(Contacts contact);

    @Delete
    public void deleteContact(Contacts contact);


    @Query("select * from Contacts")
    public List<Contacts> getContacts();

    @Query("select * from Contacts where contact_id ==:contactId")
    public Contacts getContact(long contactId);

}
