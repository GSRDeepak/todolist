package com.TodoList.service;

import com.TodoList.model.Todolist;
import com.TodoList.repo.TodoRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepo repo;

    public List<Todolist> getAllTodoList() {
       return repo.findAll();
    }

    public Todolist getTodoListById(int id) {
        return repo.findById(id).orElse(new Todolist());
    }

    public String addTodoList(Todolist todo) {
        repo.save(todo);
        return "Added Successfully";
    }

    public String deleteTodoListById(int id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    @PostConstruct
    public void createDemoDb(){
        repo.save(new Todolist("Coding","Work on the Sample spring boot project",false));
        repo.save(new Todolist("Exercise","Wakeup early and start doing exercise", true));
    }

    public String updateTodo(int id, Todolist todo) {
        Optional<Todolist> optionaltodo=repo.findById(id);
        Todolist oldtodo;
        if(optionaltodo.isEmpty()){
            return "Todo list doesn't exist";
        }
        oldtodo=optionaltodo.get();
        oldtodo.setTitle(todo.getTitle());
        oldtodo.setDescription(todo.getDescription());
        oldtodo.setCompleted(todo.getCompleted());
        repo.save(oldtodo);
        return " Todo list Updated successfully";
    }
}
