package com.example.prak_up_5.controller;

import com.example.prak_up_5.model.ToyModel;
import com.example.prak_up_5.service.ToyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/toys")

public class ToyApiController {
    private final ToyService toyService;

    public ToyApiController(ToyService toyService) {
        this.toyService = toyService;
    }

    @GetMapping
    public List<ToyModel> getAllToys() {
        return toyService.findAllToys();
    }

    @GetMapping("/{id}")
    public ToyModel getToyById(@PathVariable Long id) {
        return toyService.findToyById(id);
    }
    @PostMapping
    public ToyModel createToy(@RequestBody ToyModel toy) {
        return toyService.createToy(toy);
    }

    @PutMapping("/{id}")
    public ToyModel updateToy(@PathVariable Long id, @RequestBody ToyModel toy) {
        toy.setId(id);
        return toyService.updateToy(toy);
    }

    @DeleteMapping("/{id}")
    public void deleteToy(@PathVariable Long id) {
        toyService.deleteToy(id);
    }
}
