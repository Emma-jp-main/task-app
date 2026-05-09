package com.example.taskapp.model;

import jakarta.persistence.*;

//JPA/Hibernateを利用（↔JDBC Template）
//↑Entityを利用


//DBテーブルと対応する特別なクラスであることを明示
//taskクラスをtaskテーブルに
@Entity
public class Task {
    //主キー（PK）の明示
    @Id
    //ID自動生成
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private boolean completed;

    public Task() {
    }

    public Task(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}