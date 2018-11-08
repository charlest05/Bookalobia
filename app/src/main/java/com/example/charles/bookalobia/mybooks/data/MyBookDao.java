package com.example.charles.bookalobia.mybooks.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MyBookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertMyBook(MyBook myBook);

    @Update
    int updateMyBook(MyBook myBook);

    @Delete
    int deleteMyBook(MyBook myBook);

    @Query("SELECT * FROM my_book")
    DataSource.Factory<Integer, MyBook> getMyBooksDataSource();

    @Query("SELECT * FROM my_book")
    List<MyBook> getMyBooks();

    @Query("SELECT * FROM my_book")
    LiveData<List<MyBook>> getMyBooksLiveData();

    @Query("SELECT * FROM my_book where book_id = :bookId")
    MyBook getMyBook(int bookId);
}
