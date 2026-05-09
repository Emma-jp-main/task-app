package com.example.taskapp.dto;

//データの送受信に特化したファイル
//なのでバリデーションも行っちゃってOK
import jakarta.validation.constraints.NotBlank;

public class TaskRequest {
    @NotBlank(message = "文字を入力してください。")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
