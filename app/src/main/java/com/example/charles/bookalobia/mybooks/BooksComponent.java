package com.example.charles.bookalobia.mybooks;

import com.example.charles.bookalobia.appcore.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {BooksModule.class, AppModule.class} )
public interface BooksComponent {


}
