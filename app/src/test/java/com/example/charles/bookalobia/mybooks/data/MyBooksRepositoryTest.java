package com.example.charles.bookalobia.mybooks.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyBooksRepositoryTest {

    @Mock
    MyBookDao myBookDao;

    @Test
    public void testInsert() {
        MyBook myBook = new MyBook();
        myBook.setBookId(1);
        when(myBookDao.insertMyBook(myBook)).thenReturn(1L);

        long insertResultId = myBookDao.insertMyBook(myBook);
        assertThat(insertResultId, equalTo(1L));
    }

}
