package com.example.world_cup_app.simpleListView.jetpackbind.reclerBind;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContacctAppDatabase extends RoomDatabase {
        public abstract ContactDao getContactDao();


}
