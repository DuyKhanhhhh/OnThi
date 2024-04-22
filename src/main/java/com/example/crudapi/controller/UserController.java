package com.example.crudapi.controller;

import com.example.crudapi.model.User;
import com.example.crudapi.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = (List<User>) userService.findAll();
        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findByIdUser(@PathVariable int id){
        Optional<User> user = userService.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }{
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User user){
        return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user){
        Optional<User> users = userService.findById(id);
        if (!users.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        user.setId(users.get().getId());
        return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id){
        Optional<User> users = userService.findById(id);
        if (!users.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        userService.delete(id);
        return new ResponseEntity<>(users.get(), HttpStatus.OK);
    }
}
