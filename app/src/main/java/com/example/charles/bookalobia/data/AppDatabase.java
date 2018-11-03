package com.example.charles.bookalobia.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {BookInLibrary.class, MyBook.class}, version = 1, exportSchema = false)
public abstract class AppDatabase  extends RoomDatabase {

    private static AppDatabase DATABASE_INSTANCE;

    public static AppDatabase getDatabaseInstance(Context contex) {
        if(DATABASE_INSTANCE != null)
            return DATABASE_INSTANCE;

        DATABASE_INSTANCE = Room.databaseBuilder(contex, AppDatabase.class, "data.db")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);


                    }
                })
                .build();

        return DATABASE_INSTANCE;
    }


}
