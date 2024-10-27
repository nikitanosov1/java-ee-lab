package ru.ssau.lab1.model;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String modelName;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Car() {
    }

    public Car(String modelName, String brand) {
        this.modelName = modelName;
        this.brand = brand;
    }

    public Car(String modelName, String brand, Owner owner) {
        this.modelName = modelName;
        this.brand = brand;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
