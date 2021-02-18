package hacine.mohamed.pagingsample.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import hacine.mohamed.pagingsample.model.Word;
import hacine.mohamed.pagingsample.model.WordRepository;


public class WordViewModel extends AndroidViewModel {
    private WordRepository mWordRepository;
    private LiveData<PagedList<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mWordRepository = new WordRepository(application);
        mAllWords = mWordRepository.getAllWords();
    }

    public LiveData<PagedList<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        mWordRepository.insert(word);
    }


}
