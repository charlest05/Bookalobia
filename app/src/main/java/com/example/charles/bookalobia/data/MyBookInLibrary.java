package com.example.charles.bookalobia.data;

public class MyBookInLibrary {

    private int myBookId;

    private int bookId;

    private String bookTitle;

    private String author;

    private String imageUrl;

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

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
