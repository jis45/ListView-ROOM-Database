package com.atees.listroom;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.Vector;

public class WordsRepository {

    private  Datawords mdatawords;

    private LiveData<List<Words>>getAllwords;

    public  WordsRepository (Application app){
        RoomDatabaseClass databaseClass =RoomDatabaseClass.getInstance(app);

        mdatawords =databaseClass.datawords();
        getAllwords =mdatawords.getAllwords();
    }
    //operation

    //insert
    public  void insert(Words words){

        new InsertAsyncTask(mdatawords).execute(words);

    }

    //delete

    public  void  delete(Words words){
        new DeleteAsyncTask(mdatawords).execute(words);

    }

    //update
    public  void  update(Words words){
        new  UpdateAsyncTask(mdatawords).execute(words);

    }

    //getallwords

    public LiveData<List<Words>> getGetAllwords() {
        return getAllwords;
    }

    //detete all words

    public  void  deleteAllwords(){
        new DeieteAllwordAsyncTask(mdatawords).execute();

    }

    private  static  class  InsertAsyncTask extends AsyncTask<Words, Void,Void>{
        private  Datawords mdatawords;
        private  InsertAsyncTask(Datawords datawords){
            mdatawords=datawords;
        }
        @Override
        protected Void doInBackground(Words... words) {
            mdatawords.insert(words[0]);
            return null;
        }
    }
    private  static  class  DeleteAsyncTask extends AsyncTask<Words, Void,Void>{
        private  Datawords mdatawords;
        private  DeleteAsyncTask(Datawords datawords){
            mdatawords=datawords;
        }
        @Override
        protected Void doInBackground(Words... words) {
            mdatawords.delete(words[0]);
            return null;
        }
    }
    private  static  class  UpdateAsyncTask extends AsyncTask<Words, Void,Void>{
        private  Datawords mdatawords;
        private  UpdateAsyncTask(Datawords datawords){
            mdatawords=datawords;
        }
        @Override
        protected Void doInBackground(Words... words) {
            mdatawords.update(words[0]);
            return null;
        }
    }
    private  static  class  DeieteAllwordAsyncTask extends AsyncTask<Void, Void,Void>{
        private  Datawords mdatawords;
        private  DeieteAllwordAsyncTask(Datawords datawords){
            mdatawords=datawords;
        }
        @Override
        protected Void doInBackground(Void... voids) {
          mdatawords.deleteAllwords();
            return null;
        }
    }


}
