package com.example.taskapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//「このクラスはAPIですよ」って宣言。JSONを返す
@RestController
public class TaskController {
    private List<String> tasks = new ArrayList<>();

    //POST /tasks → データを追加
        //フロント（HTML）
        //  ↓ POST
        //バックエンド（Spring Boot）
        //  ↓ 保存
        //メモリ（List）
    //GET  /tasks → データを取得
        //フロント
        //  ↑ GET
        //バックエンド
        //  ↑ データ返す

    //URLの後ろに/tasksと入るとtaskのJSONを返す
    //自動でJava ↔ JSON変換されてる
    //これはSpring Bootが内部でやってる
    @GetMapping("/tasks")
    public List<String> getTasks() {
        return tasks;
    }

    @PostMapping("/tasks")
    //RequestBody > リクエストの中身を取り出す
    public void addTask(@RequestBody String task) {
        tasks.add(task);
    }
}
