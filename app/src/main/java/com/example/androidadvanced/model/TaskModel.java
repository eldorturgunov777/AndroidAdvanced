package com.example.androidadvanced.model;

/**
 * Created by Eldor Turgunov on 16.06.2022.
 * Android Advanced
 * eldorturgunov777@gmail.com
 */
public class TaskModel {
    String task, title;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskModel(String task, String title) {
        this.task = task;
        this.title = title;
    }
}
