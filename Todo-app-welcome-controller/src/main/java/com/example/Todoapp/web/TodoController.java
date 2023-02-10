package com.example.Todoapp.web;

import com.example.Todoapp.entity.Todo;
import com.example.Todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class TodoController {


    static Logger logger= Logger.getLogger("TodoController");

    @Autowired
    TodoRepository todoRepository;


    // all
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/todos",
            produces = {"application/json","application/xml"}
    )
    public Collection<Todo> getAll(){
        Collection<Todo>todos= todoRepository.findAll();
        logger.info("listed all todos");
        return todos;
    }




//    // all use getMapping
//    @GetMapping("/todos")
//    public Collection<Todo> getAllTodos(){
//        Collection<Todo> todos = todoRepository.findAll();
//        return todos;
//    }

    // get specific todo
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/todos/{todoId}",
            produces = {"application/json","application/xml"}
    )
    public ResponseEntity<Object> getTodo(@PathVariable(name = "todoId") int todoId){
        Optional<Todo> todo= todoRepository.findById(todoId);
        if(todo.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(todo.get());
    }

    // add todo
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/todos",
            consumes = {"application/json","application/xml"}
    )
    public ResponseEntity<?> addTodo(@RequestBody Todo todo){
        todo = todoRepository.save(todo);

        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    // remove todo

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/todos/{todoId}",
            consumes = {"application/json","application/xml"}
    )
    public ResponseEntity<?> removeTodo(@PathVariable (name = "todoId") int todoId){
        todoRepository.deleteById(todoId);
        return ResponseEntity.status(HttpStatus.OK).build();

    }




}
