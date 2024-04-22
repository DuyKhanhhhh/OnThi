package com.example.onthiapib1.controller;

import com.example.onthiapib1.model.User;
import com.example.onthiapib1.service.imlp.RoleService;
import com.example.onthiapib1.service.imlp.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private Validator validator;

    @GetMapping
    public String showAllUsers(@PageableDefault(4) Pageable pageable, Model model) {
        model.addAttribute("listUser", userService.findAll(pageable));
        return "index";
    }

    @GetMapping("save")
    public String showFromSave(Model model) {
        model.addAttribute("users", new User());
        model.addAttribute("role", roleService.getAllRoles());
        return "create";
    }

    @PostMapping("save")
    public String saveUser(@ModelAttribute("users") @Valid User user, BindingResult bindingResult, Model model) {
        validator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", bindingResult.getFieldError().getDefaultMessage());
            return "create";
        }else {
            userService.save(user);
            return "redirect:/user";
        }
    }

    @GetMapping("update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("users", user.get());
            model.addAttribute("role", roleService.getAllRoles());
        }
        return "update";
    }

    @PostMapping("update")
    public String updateUser(@ModelAttribute("users") User user) {
        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.remove(id);
        return "redirect:/user";
    }

    @GetMapping("search")
    public String search(@RequestParam("name") String name, Model model) {
        Iterable<User> users = userService.findByName(name);
        model.addAttribute("listUser", users);
        return "index";
    }
}
