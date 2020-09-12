package com.example.roomdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Human.class},version = 1,exportSchema = false)
public abstract class Humandatabase extends RoomDatabase {
    public abstract HumanDao humanDao();

}
