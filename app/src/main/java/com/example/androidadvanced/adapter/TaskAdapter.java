package com.example.androidadvanced.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidadvanced.R;
import com.example.androidadvanced.model.TaskModel;

import java.util.ArrayList;

/**
 * Created by Eldor Turgunov on 16.06.2022.
 * Android Advanced
 * eldorturgunov777@gmail.com
 */
public class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<TaskModel> items;
    OnNoteListener mOnNoteListener;

    public TaskAdapter(Context context, ArrayList<TaskModel> items, OnNoteListener mOnNoteListener) {
        this.context = context;
        this.items = items;
        this.mOnNoteListener = mOnNoteListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_task, parent, false);
        return new ItemViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).task.setText(items.get(position).getTask());
            ((ItemViewHolder) holder).title.setText(items.get(position).getTitle());
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView task, title;
        OnNoteListener onNoteListener;

        public ItemViewHolder(View view, OnNoteListener onNoteListener) {
            super(view);
            task = view.findViewById(R.id.tv_tasks);
            title = view.findViewById(R.id.tv_title);
            this.onNoteListener = onNoteListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener {
        void onClick(int position);
    }
}
