package com.example.charles.bookalobia.mybooks;

import com.example.charles.bookalobia.appcore.AppDatabase;
import com.example.charles.bookalobia.mybooks.data.MyBookRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BooksModule {

    @Provides
    @Singleton
    public MyBookRepository provideMyBooksRepository(AppDatabase appDatabase) {
        return new MyBookRepository(appDatabase.getMyBookDao());
    }

}
