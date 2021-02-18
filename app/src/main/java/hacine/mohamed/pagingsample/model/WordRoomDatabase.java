package hacine.mohamed.pagingsample.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {
    public abstract WordDao wordDao();

    private static WordRoomDatabase INSTANCE;
    public static ExecutorService sExecutorService = Executors.newFixedThreadPool(4);

    public static WordRoomDatabase getDatabase(Context context){
        if(INSTANCE == null){
            synchronized (WordRoomDatabase.class){
                if(INSTANCE == null){

                     INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // dummy stuff to add files to db, everytime app starts
    private static Callback sRoomDatabaseCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
//            new PopulateDbAsync(INSTANCE).execute();


            String[] words = {"dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "checki",

                    "zoom", "zoom2", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "checki", "zoom", "zoom2", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech", "dolphin", "crocodile", "cobra", "check", "check", "nigga", "boy", "ziyech"};

            sExecutorService.execute(() -> {
                WordDao mDao;
                mDao = INSTANCE.wordDao();
                mDao.deleteAll();

                for (int i = 0; i <= words.length - 1; i++) {
                    Word word = new Word(words[i]);
                    mDao.insert(word);
                }
            });
        }
    };



    /**
     *
     * Populate the database in the background.
     *
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WordDao mDao;
        String[] words = {"dolphin", "crocodile", "cobra"};

        PopulateDbAsync(WordRoomDatabase db) {
            mDao = db.wordDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created
            mDao.deleteAll();

            for (int i = 0; i <= words.length - 1; i++) {
                Word word = new Word(words[i]);
                mDao.insert(word);
            }
            return null;
        }
    }

}
