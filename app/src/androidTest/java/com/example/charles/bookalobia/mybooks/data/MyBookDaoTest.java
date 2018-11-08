package com.example.charles.bookalobia.mybooks.data;

import com.example.charles.bookalobia.appcore.AppDatabase;
import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import static com.example.charles.bookalobia.mybooks.testutils.TestUtils.getValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class MyBookDaoTest {

    private AppDatabase roomDatabase;

    private MyBookDao myBookDao;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        roomDatabase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase.class).build();
        myBookDao = roomDatabase.getMyBookDao();
    }

    @Test
    public void testInsert() {
        MyBook myBook =  new MyBook();
        myBook.setAuthor("Ako");

        myBookDao.insertMyBook(myBook);
        List<MyBook> myBooksLiveData = myBookDao.getMyBooks();

        Truth.assertThat(myBooksLiveData.get(0).getAuthor()).isEqualTo("Ako");
    }

    @Test
    public void testInsertLiveData() throws InterruptedException {
        MyBook myBook =  new MyBook();
        myBook.setAuthor("Ako");

        myBookDao.insertMyBook(myBook);
        LiveData<List<MyBook>> myBooksLiveData = myBookDao.getMyBooksLiveData();

        Truth.assertThat(getValue(myBooksLiveData).get(0).getAuthor()).isEqualTo("Ako");
    }

    @Test
    public void testUpdate() {
        MyBook myBook = new MyBook();
        myBook.setAuthor("Me");
        myBook.setBookId(1);

        int updatedMyuBookCount = myBookDao.updateMyBook(myBook);
        Truth.assertThat(updatedMyuBookCount).isEqualTo(0);

        long bookID = myBookDao.insertMyBook(myBook);
        assertThat(bookID, equalTo(1L));

        updatedMyuBookCount = myBookDao.updateMyBook(myBook);
        Truth.assertThat(updatedMyuBookCount).isEqualTo(1);


        myBook = new MyBook();
        myBook.setAuthor("Me");
        myBook.setBookId(1);

        bookID = myBookDao.insertMyBook(myBook);
        assertThat(bookID, equalTo(1L));
    }

    @Test
    public void testDelete() {
        MyBook myBook = new MyBook();
        myBook.setBookId(1);

        int affected = myBookDao.deleteMyBook(myBook);
        assertThat(affected, equalTo(0));

        myBookDao.insertMyBook(myBook);

        affected = myBookDao.deleteMyBook(myBook);
        assertThat(affected, equalTo(1));

        myBookDao.insertMyBook(myBook);
        myBook.setBookId(2);
        myBookDao.insertMyBook(myBook);

        affected = myBookDao.deleteMyBook(myBook);
        assertThat(affected, equalTo(1));

    }

}
