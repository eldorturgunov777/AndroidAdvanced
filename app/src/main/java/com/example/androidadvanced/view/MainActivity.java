package com.example.androidadvanced.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidadvanced.R;
import com.example.androidadvanced.adapter.TaskAdapter;
import com.example.androidadvanced.model.TaskModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TaskAdapter.OnNoteListener {
    RecyclerView recyclerView;
    ArrayList<TaskModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        TaskAdapter adapter = new TaskAdapter(this, list, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        data();
    }

    void data() {
        list.add(new TaskModel("1", "Dependencies, Localization"));
        list.add(new TaskModel("2", "Shared Preferences"));
        list.add(new TaskModel("3", "SQL & NoSQL Databases"));
        list.add(new TaskModel("4", "Internal & External Storages"));
        list.add(new TaskModel("5", "Service, Broadcast Receiver"));
        list.add(new TaskModel("6", "Network Request"));
        list.add(new TaskModel("7", "Response Parsing"));
        list.add(new TaskModel("8", "Firebase Setting, Auth"));
        list.add(new TaskModel("9", "Firebase Database"));
        list.add(new TaskModel("10", "Firebase Storage"));
    }

    @Override
    public void onClick(int position) {
        switch (position) {
            case 0: {
                Intent intent = new Intent(this, FirstActivity.class);
                startActivity(intent);
                break;
            }
            case 1: {
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}