package com.example.charles.bookalobia.data;

import java.util.List;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


@Dao
public interface BookLibraryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    DataSource.Factory<Integer, BookInLibrary> insertBooksToLibrary(List<BookInLibrary> bookInLibraries);

    @Query("SELECT * FROM BookInLibrary WHERE bookId = :bookId")
    BookInLibrary getBookInLibrary(int bookId);



}
