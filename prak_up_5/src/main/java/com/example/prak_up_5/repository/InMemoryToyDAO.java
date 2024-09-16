package com.example.prak_up_5.repository;


import com.example.prak_up_5.model.ToyModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
public class InMemoryToyDAO {
    private final List<ToyModel> toys = new ArrayList<>();

    public List<ToyModel> findAllToys() {
        return toys;
    }

    public Optional<ToyModel> findToyById(Long id) {
        return toys.stream()
                .filter(toy -> toy.getId().equals(id))
                .findFirst();
    }

    public ToyModel createToy(ToyModel toy) {
        toys.add(toy);
        return toy;
    }

    public ToyModel updateToy(ToyModel toy) {
        var toyIndex = IntStream.range(0, toys.size())
                .filter(index -> toys.get(index).getId().equals(toy.getId()))
                .findFirst()
                .orElse(-1);
        if (toyIndex == -1) {
            return null;
        }
        toys.set(toyIndex, toy);
        return toy;
    }

    public void deleteToy(Long id) {
        findToyById(id).ifPresent(toys::remove);
    }
}
