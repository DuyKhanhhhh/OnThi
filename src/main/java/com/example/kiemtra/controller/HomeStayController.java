package com.example.kiemtra.controller;

import com.example.kiemtra.model.City;
import com.example.kiemtra.model.HomeStay;
import com.example.kiemtra.service.ICityService;
import com.example.kiemtra.service.IHomeStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("homeStay")
public class HomeStayController {
    @Autowired
    private IHomeStayService homeStayService;
    @Autowired
    private ICityService cityService;
    @GetMapping
    private String showAll(Model model){
        model.addAttribute("homeStay", homeStayService.findAll());
        return "homeStay/homeStay";
    }
    @GetMapping("create")
    private String showFromCreate(Model model){
        model.addAttribute("homeStay", new HomeStay());
        model.addAttribute("city", cityService.findAll());
        return "homeStay/create";
    }
    @PostMapping("create")
    private String createCity(@ModelAttribute HomeStay homeStay, RedirectAttributes redirectAttributes){
        homeStayService.save(homeStay);
        redirectAttributes.addFlashAttribute("message", "Create HomeStay success");
        return "redirect:/homeStay";
    }
    @GetMapping("update/{id}")
    private String showFromUpdate(@PathVariable int id, Model model){
        Optional<HomeStay> homeStay = homeStayService.findById(id);
        if (homeStay.isPresent()){
            model.addAttribute("homeStay", homeStay.get());
            model.addAttribute("city", cityService.findAll());
            return "homeStay/update";
        }else {
            model.addAttribute("message", "ERROR-404");
            return "redirect:/homeStay";
        }
    }
    @PostMapping("update")
    private String updateHomeStay(@ModelAttribute HomeStay homeStay, RedirectAttributes redirectAttributes){
        homeStayService.save(homeStay);
        redirectAttributes.addFlashAttribute("message", "Update HomeStay success");
        return "redirect:/homeStay";
    }
    @GetMapping("delete/{id}")
    private String deleteHomeStay(@PathVariable int id, RedirectAttributes redirectAttributes){
        homeStayService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete HomeStay success");
        return "redirect:/homeStay";
    }
    @GetMapping("search")
    private String searchCity(@RequestParam String keyword, Model model){
        Iterable<HomeStay> homeStay = homeStayService.findByName(keyword);
        model.addAttribute("homeStay", homeStay);
        return "homeStay/homeStay";
    }
}
