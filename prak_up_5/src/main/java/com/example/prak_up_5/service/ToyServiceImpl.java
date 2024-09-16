package com.example.prak_up_5.service;


import com.example.prak_up_5.model.ToyModel;
import com.example.prak_up_5.repository.ToyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyServiceImpl implements ToyService{
    private final ToyRepository repository;

    public ToyServiceImpl(ToyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ToyModel> findAllToys() {
        return repository.findAll();
    }

    @Override
    public ToyModel createToy(ToyModel toy) {
        return repository.save(toy);
    }

    @Override
    public ToyModel updateToy(ToyModel toy) {
        return repository.save(toy);
    }

    @Override
    public ToyModel findToyById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteToy(Long id) {
        repository.deleteById(id);
    }
}
