package com.example.taskapp.controller;

import com.example.taskapp.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//「このクラスはAPIですよ」って宣言。JSONを返す
@RestController
public class TaskController {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

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
    public List<Task> getTasks() {
        return tasks;
    }

    @PostMapping("/tasks")
    //RequestBody > リクエストの中身を取り出す(JSON → Taskオブジェクト変換)
    public void addTask(@RequestBody java.util.Map<String, String> body) {
        System.out.println("受信Body: " + body);
        Task task = new Task();
        task.setId(nextId++);
        //上でMapを作らなくても、@RequestBody Task taskとすれば本来は自動的にsetTitleされるはず
        task.setTitle(body.get("title"));
        task.setCompleted(false);
        tasks.add(task);
    }

    @DeleteMapping("/tasks/{id}")
    //PathVariableでidを取得：/tasks/3 ならid=3
    public void deleteTask(@PathVariable int id) {
        //条件に合致したらtaskを削除
        tasks.removeIf(task -> task.getId() == id);
    }
}
