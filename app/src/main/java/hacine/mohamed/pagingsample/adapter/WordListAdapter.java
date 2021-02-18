package hacine.mohamed.pagingsample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;


import java.util.Objects;

import hacine.mohamed.pagingsample.R;
import hacine.mohamed.pagingsample.model.Word;

public class WordListAdapter extends PagedListAdapter<Word, WordListAdapter.WordViewHolder> {

    public WordListAdapter() {
        super(sItemCallback);
    }

    private static DiffUtil.ItemCallback<Word> sItemCallback = new DiffUtil.ItemCallback<Word>() {
        @Override
        public boolean areItemsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return Objects.equals(oldItem, newItem);
        }
    };


    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
          Word currentWord = getItem(position);
          if(currentWord != null){
              holder.wordItemView.setText(currentWord.getWord());
          }
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    Word currentWord = getItem(position);
                    Toast.makeText(itemView.getContext(),currentWord.getWord() , Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

