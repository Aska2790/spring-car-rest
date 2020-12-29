package com.aska.development.carrestapi.services;

import com.aska.development.carrestapi.entities.Car;

import java.util.List;

public interface CarService {

    Car findById(Long id);

    List<Car> findAll();

    List<Car> findAll(String filter);

    void delete(Long id);

    void save(Car car);

}
