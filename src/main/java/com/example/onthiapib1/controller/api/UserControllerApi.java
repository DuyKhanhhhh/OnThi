package com.example.onthiapib1.controller.api;

import com.example.onthiapib1.model.User;
import com.example.onthiapib1.service.imlp.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserControllerApi {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<Page<User>> showAllUsers(@PageableDefault(2) Pageable pageable) {
        Page<User> users = userService.findAll(pageable);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") int id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            StringBuilder builder = new StringBuilder();
            for (FieldError fieldError : fieldErrors) {
                builder.append(fieldError.getField()).append(" : ").append(fieldError.getDefaultMessage()).append("\n");
            }
            return new ResponseEntity<>(builder.toString(), HttpStatus.BAD_REQUEST);
        }
        User users = userService.save(user);
        return new ResponseEntity<>("Create success", HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            user.setId(id);
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        userService.remove(id);
        return new ResponseEntity<>(userOptional.get(), HttpStatus.NO_CONTENT);
    }

}
