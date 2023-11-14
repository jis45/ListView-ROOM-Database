package com.atees.listroom;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database( entities = {Words.class},version = 1)
public abstract class RoomDatabaseClass extends RoomDatabase {

    private  static  RoomDatabaseClass instance;

    public abstract Datawords datawords();

    public static  synchronized  RoomDatabaseClass getInstance(Context context){
        if(instance == null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    RoomDatabaseClass.class,"DATA-database")
                    .enableMultiInstanceInvalidation()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }
    private  static  RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDataAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
    private  static  class  PopulateDataAsyncTask extends AsyncTask<Void,Void,Void>{

        private  Datawords mdatawords;

        PopulateDataAsyncTask(RoomDatabaseClass roomDatabaseClass){
            mdatawords = roomDatabaseClass.datawords();

        }

        @Override
        protected Void doInBackground(Void... voids) {

            mdatawords.insert(new Words("personname","personemail","type"));
//            mdatawords.insert(new Words("personname","personemail"));
//            mdatawords.insert(new Words("personname","personemail"));


            return null;
        }
    }
}
