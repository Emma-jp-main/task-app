package com.example.taskapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//「このクラスはAPIですよ」って宣言。JSONを返す
@RestController
public class TaskController {

    //URLの後ろに/tasksと入るとokを返す
    @GetMapping("/tasks")
    public String test() {
        return "ok";
    }
}
