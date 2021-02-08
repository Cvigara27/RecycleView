package com.cifpfbmoll.recycleview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.zip.Inflater;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder> {

    private LayoutInflater inflater;
    private LinkedList<String> wordList;

    public RecycleAdapter(Context context, LinkedList<String> wordList){
        super();
        inflater = LayoutInflater.from(context);
        this.wordList = wordList;
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View mItemView = inflater.inflate(R.layout.list_item, parent, false);
        return new RecycleViewHolder(mItemView, this);
    }



    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        String mCurrent = wordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView wordItemView;
        private RecycleAdapter recycleAdapter;

        public RecycleViewHolder(@NonNull View itemView, RecycleAdapter recycleAdapter) {
            super(itemView);
            wordItemView = (TextView)itemView.findViewById(R.id.word);
            this.recycleAdapter = recycleAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            wordItemView.setText("Clicked"+wordItemView.getText());
            wordList.set(getLayoutPosition(), (String)wordItemView.getText());
        }
    }
}
