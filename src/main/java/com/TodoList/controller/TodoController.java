package com.TodoList.controller;

import com.TodoList.model.Todolist;
import com.TodoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todolist")
public class TodoController {

    @GetMapping("/")
    public String greetings(){
        return "Hello world";
    }
   @Autowired
   private TodoService service;

    @GetMapping("/alltodos")
    public List<Todolist> getAllTodolist(){
        return service.getAllTodoList();
    }

    @GetMapping("/todo/{id}")
    public Todolist getTodoListById(@PathVariable int id){
        return service.getTodoListById(id);
    }

    @PostMapping("/addtodo")
    public String addTodoList(@RequestBody Todolist todo){
        return service.addTodoList(todo);
    }

    @DeleteMapping("/deletetodo/{id}")
    public String deleteTodoListById(@PathVariable int id){
       return service.deleteTodoListById(id);
    }
}
