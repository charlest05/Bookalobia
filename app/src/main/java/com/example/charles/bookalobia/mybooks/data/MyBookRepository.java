package com.example.charles.bookalobia.mybooks.data;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class MyBookRepository {

    private MyBookDao myBookDao;

    public MyBookRepository(MyBookDao myBookDao) {
        this.myBookDao = myBookDao;
    }

    public long insertMyBook(MyBook myBook) {
        return myBookDao.insertMyBook(myBook);
    }

    public int updateMyBook(MyBook myBook) {
        return myBookDao.updateMyBook(myBook);
    }

    public int deleteMyBook(MyBook myBook) {
        return myBookDao.deleteMyBook(myBook);
    }

    public LiveData<PagedList<MyBook>>getMyBooksLiveData() {
        return new LivePagedListBuilder<>(myBookDao.getMyBooksDataSource(), 20).build();
    }
}
