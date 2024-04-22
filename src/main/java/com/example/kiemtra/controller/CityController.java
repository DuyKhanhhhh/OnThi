package com.example.kiemtra.controller;

import com.example.kiemtra.model.City;
import com.example.kiemtra.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("city")
public class CityController {
    @Autowired
    private ICityService cityService;
    @GetMapping
    private String showAll(Model model){
        model.addAttribute("city", cityService.findAll());
        return "city/city";
    }
    @GetMapping("create")
    private String showFromCreate(Model model){
        model.addAttribute("city", new City());
        return "city/create";
    }
    @PostMapping("create")
    private String createCity(@ModelAttribute City city, RedirectAttributes redirectAttributes){
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message", "Create city success");
        return "redirect:/city";
    }
    @GetMapping("update/{id}")
    private String showFromUpdate(@PathVariable int id, Model model){
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()){
            model.addAttribute("city", city.get());
            return "city/update";
        }else {
            model.addAttribute("message", "ERROR-404");
            return "redirect:/city";
        }
    }
    @PostMapping("update")
    private String updateCity(@ModelAttribute City city, RedirectAttributes redirectAttributes){
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message", "Update city success");
        return "redirect:/city";
    }
    @GetMapping("delete/{id}")
    private String deleteCity(@PathVariable int id, RedirectAttributes redirectAttributes){
        cityService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete city success");
        return "redirect:/city";
    }
}
