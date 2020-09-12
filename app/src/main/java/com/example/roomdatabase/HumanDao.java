package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HumanDao {
    @Insert
    void insert(Human human);
    @Query("select * from human")
    List<Human> getAll();

}
