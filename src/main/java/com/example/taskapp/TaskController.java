package com.example.taskapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//「このクラスはAPIですよ」って宣言。JSONを返す
@RestController
public class TaskController {

    //URLの後ろに/tasksと入るとtaskのJSONを返す
    //自動でJSON変換されてる
    //これはSpring Bootが内部でやってる
    @GetMapping("/tasks")
    public List<String> getTasks() {
        return List.of("task1", "task2");
    }
}
