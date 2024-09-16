package com.example.prak_up_5.controller;
import com.example.prak_up_5.model.ToyModel;
import com.example.prak_up_5.service.ToyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToyController {
    @Qualifier("toyServiceImpl")
    @Autowired
    private ToyService toyService;

    @GetMapping("/toys")
    public String getAllToys(Model model) {
        List<ToyModel> toys = toyService.findAllToys();
        model.addAttribute("toys", toys);
        model.addAttribute("toy", new ToyModel());

        return "toys";
    }

    @PostMapping("/toys")
    public String addToy(@Valid @ModelAttribute ToyModel toy, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<ToyModel> toys = toyService.findAllToys();
            model.addAttribute("toys", toys);
            model.addAttribute("toy", new ToyModel());

            return "toys";
        }
        toyService.createToy(toy);
        return "redirect:/toys";
    }

    @GetMapping("/toys/edit/{id}")
    public String editToy(@PathVariable Long id, Model model) {
        ToyModel toy = toyService.findToyById(id);
        model.addAttribute("toy", toy);
        return "editToy";
    }

    @PostMapping("/toys/update")
    public String updateToy(@Valid @ModelAttribute ToyModel toy, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors: " + bindingResult.getAllErrors());
            List<ToyModel> toys = toyService.findAllToys();
            model.addAttribute("toys", toys);
            model.addAttribute("toy", toy);
            return "toys";
        }
        toyService.updateToy(toy);
        return "redirect:/toys";
    }

    @GetMapping("/toys/delete/{id}")
    public String deleteToy(@PathVariable Long id) {
        toyService.deleteToy(id);
        return "redirect:/toys";
    }
}
