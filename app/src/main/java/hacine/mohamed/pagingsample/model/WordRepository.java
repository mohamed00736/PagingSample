package hacine.mohamed.pagingsample.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<PagedList<Word>> mAllWords;  // liveData of list of words object

    public WordRepository(Application application) {
        WordRoomDatabase database = WordRoomDatabase.getDatabase(application);
        mWordDao = database.wordDao();
        mAllWords = new LivePagedListBuilder<>(mWordDao.getAllWords(), 10).build();
    }

    public LiveData<PagedList<Word>> getAllWords(){
        return mAllWords;
    }



    public void insert(Word word){


        //WordRoomDatabase.sExecutorService.execute(() -> mWordDao.insert(word));

        WordRoomDatabase.sExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                mWordDao.insert(word);
            }
        });

    }






}
