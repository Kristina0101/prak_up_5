package com.example.prak_up_5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "toy")
public class ToyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_toy")
    private Long id;

    @NotBlank(message = "Название не должно быть пустым")
    @Size(max = 100, message = "Название должно быть не более 100 символов")
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255, message = "Описание должно быть не более 255 символов")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Цена не может быть пустой")
    @Min(value = 0, message = "Цена не может быть отрицательной")
    @Column(name = "price", nullable = false)
    private Double price;

    @Size(max = 50, message = "Категория должна быть не более 50 символов")
    @Column(name = "category")
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
