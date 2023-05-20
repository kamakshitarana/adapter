package com.example.world_cup_app.simpleListView.RoomDb;


//Abstract class

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Contacts.class},version = 1, exportSchema = false)
public abstract class ContactsAppDatabase extends RoomDatabase {

    // Linking the DAO with our Database
    public abstract ContactDAO getContactDAO();

}
