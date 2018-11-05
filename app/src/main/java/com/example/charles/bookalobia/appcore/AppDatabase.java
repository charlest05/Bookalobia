package com.example.charles.bookalobia.appcore;

import android.content.Context;

import com.example.charles.bookalobia.mybooks.data.MyBook;
import com.example.charles.bookalobia.mybooks.data.MyBookDao;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(
        entities = {MyBook.class},
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MyBookDao getMyBookDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if(INSTANCE != null)
            return INSTANCE;

        INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "db.db")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);


                    }
                })
                .build();

        return INSTANCE;
    }
}
