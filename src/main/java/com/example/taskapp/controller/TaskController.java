package com.example.taskapp.controller;

import com.example.taskapp.dto.TaskRequest;
import com.example.taskapp.model.Task;
import com.example.taskapp.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//「このクラスはAPIですよ」って宣言。JSONを返す
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


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
    @GetMapping
    public List<Task> getTasks() {
        //DBはデータ保存については強いが、並び順などは自分で指定する必要がある
        return taskRepository.findAllByOrderByIdAsc();
    }

    @PostMapping
    //RequestBody > リクエストの中身を取り出す(JSON → Taskオブジェクト変換)
    //Dtoでバリデーションしたものはここで@Validを書かないと実行されない
    public Task addTask(@Valid @RequestBody TaskRequest taskRequest) {
        Task task = new Task();
        //インスタンス化した際に、idは自動入力される(@GenerateValue）
        task.setTitle(taskRequest.getTitle());
        task.setCompleted(false);
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    //PathVariableでidを取得：/tasks/3 ならid=3
    public void deleteTask(@PathVariable int id) {
        taskRepository.deleteById(id);
    }

    //toggle = 切り替え
    @PatchMapping("/{id}/toggle")
    public void toggleTask(@PathVariable int id) {
        //orElseThrow() →見つからなければエラー
        Task task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
