package com.example.charles.bookalobia.data;

import java.util.Calendar;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = BookInLibrary.class, childColumns = "myBookId", parentColumns = "bookId")})
public class MyBook {

    @PrimaryKey(autoGenerate = true)
    private int myBookId;

    private int bookId;

    private Calendar readDate = Calendar.getInstance();

    public int getMyBookId() {
        return myBookId;
    }

    public void setMyBookId(int myBookId) {
        this.myBookId = myBookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Calendar getReadDate() {
        return readDate;
    }

    public void setReadDate(Calendar readDate) {
        this.readDate = readDate;
    }
}
