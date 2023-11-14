package com.atees.listroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class WordViewModel  extends AndroidViewModel {
    private WordsRepository mwordsRepository;

    private LiveData<List<Words>>mAllwords;



    public WordViewModel(@NonNull Application application) {
        super(application);
        mwordsRepository =new WordsRepository(application);
        mAllwords=mwordsRepository.getGetAllwords();
    }

    public  void insert(Words words){
        mwordsRepository.insert(words);
    }
    public  void delete(Words words){
        mwordsRepository.delete(words);
    }
    public  void update(Words words){
        mwordsRepository.update(words);
    }
    public  void deleteAllword(){
        mwordsRepository.deleteAllwords();
    }

    public LiveData<List<Words >> getAllWords(){
     return  mAllwords;
    }
}
