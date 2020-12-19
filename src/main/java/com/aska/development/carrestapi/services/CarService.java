package com.aska.development.carrestapi.services;

import com.aska.development.carrestapi.services.dto.Car;

import java.util.List;
import java.util.Map;

public interface CarService {

    Car findById(Long id);

    List<Car> findAll();

    List<Car> findAll(Map<String, String> params);

    void delete(Long id);

    void update(Car car);

    void insert(Car car);
}
