package hacine.mohamed.pagingsample;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Math.pow;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "REPLY";

    private EditText mEditWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mEditWord = findViewById(R.id.edit_word);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(V -> {
            Intent intent = new Intent();
            if(TextUtils.isEmpty(mEditWord.getText())){
                setResult(RESULT_CANCELED, intent);
            } else{
                String word = mEditWord.getText().toString();
                intent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, intent);
            }
            finish();
        });
    }



}