package com.atees.listroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AddViewModel extends AndroidViewModel {

    private WordsRepository mwordsRepository;


    public AddViewModel(@NonNull Application application) {
        super(application);
        mwordsRepository = new WordsRepository(application);
    }

    public void insert(Words words) {
        mwordsRepository.insert(words);
    }

    public void update(Words words) {
        mwordsRepository.update(words);
    }

}
