package com.example.charles.bookalobia.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MyBookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMyBook(MyBook myBook);

    @Update
    void updateMyBook(MyBook myBook);

    @Delete
    void deleteMyBook(MyBook myBook);
}
