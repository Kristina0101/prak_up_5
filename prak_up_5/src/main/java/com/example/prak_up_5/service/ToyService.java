package com.example.prak_up_5.service;

import com.example.prak_up_5.model.ToyModel;

import java.util.List;

public interface ToyService {
    List<ToyModel> findAllToys();
    ToyModel createToy(ToyModel toy);
    ToyModel updateToy(ToyModel toy);
    ToyModel findToyById(Long id);
    void deleteToy(Long id);
}