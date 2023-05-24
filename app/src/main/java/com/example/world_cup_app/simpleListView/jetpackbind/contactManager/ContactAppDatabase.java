package com.example.world_cup_app.simpleListView.jetpackbind.contactManager;

import androidx.room.Database;
import androidx.room.RoomDatabase;



@Database(entities = {Contact.class},version = 2)

public abstract class ContactAppDatabase extends RoomDatabase {
    public abstract StudentDao getContactDAO();

}
