package com.example.handesaimandroidcoursecompletionproject;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Item.class,  User.class, UserItemsCrossRef.class},version = 1,exportSchema = false)
public abstract class DataBase extends RoomDatabase {

    public abstract ItemDao ItemDao();
    public abstract UserDao UserDao();



    private static volatile Database INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // If you want to keep data through app restarts,
            // comment out the following block
/*            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                ItemDao dao = INSTANCE.itemDao();
                dao.deleteAll();
                *//*Word word = new Word("Hello");
                dao.insert(word);
                word = new Word("World");
                dao.insert(word);*//*
            });*/
        }
    };

    static DataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = (Database) Room.databaseBuilder(context.getApplicationContext(),
                            DataBase.class, "RoomDataBase")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return (DataBase) INSTANCE;
    }

}
