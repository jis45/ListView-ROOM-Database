package com.atees.listroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WordAdaptor extends RecyclerView.Adapter<WordAdaptor.ViewHolder> {

    private List<Words> mWordsList =new ArrayList<>();

    @NonNull
    @Override
    public WordAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull WordAdaptor.ViewHolder holder, int position) {
        Words currentWord =mWordsList.get(position);
        holder.textViewName.setText(currentWord.getName());
        holder.textViewEmail.setText(currentWord.getEmail());
        holder.textViewType.setText(currentWord.getPersontype());


    }
    public  void setWords(List<Words>words) {
        mWordsList =words;
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return mWordsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName ,textViewEmail,textViewType;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName =itemView.findViewById(R.id.Name);
            textViewEmail=itemView.findViewById(R.id.Email);
            textViewType =itemView.findViewById(R.id.type);
        }
    }
}
