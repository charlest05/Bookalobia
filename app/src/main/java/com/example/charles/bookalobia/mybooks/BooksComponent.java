package com.example.charles.bookalobia.mybooks;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {BooksModule.class} )
public interface BooksComponent {

}
