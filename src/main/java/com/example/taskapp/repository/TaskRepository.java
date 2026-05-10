package com.example.taskapp.repository;

import com.example.taskapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//JpaRepository<対象Entity, PK>
//これだけでsave(),findAll(),deleteById()使える
//Repositoryは Integer 指定が自然（Java Generics都合）
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    //これだけ（派生クエリメソッド）でJPAがSQLを自動生成
    //内部的にはSELECT * FROM task ORDER BY id ASC;
    List<Task> findAllByOrderByIdAsc();
}
