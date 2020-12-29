package com.aska.development.carrestapi.controllers;

import com.aska.development.carrestapi.entities.Car;
import com.aska.development.carrestapi.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CarController {

    //region Fields

    private CarService mService;

    //endregion

    //region Constructors

    @Autowired
    public CarController(CarService service) {
        mService = service;
    }

    //endregion

    //region Methods

    @GetMapping
    public List<Car> select(@RequestParam(required = false) String filter) {
        return mService.findAll(filter);
    }

    @GetMapping("{id}")
    public Car select(@PathVariable Long id) {
        return mService.findById(id);
    }

    @PostMapping
    public Car create(@RequestBody Car car) {
        mService.save(car);
        return car;
    }

    @PutMapping
    public Car update(@RequestBody Car car) {
        mService.save(car);
        return car;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        mService.delete(id);
    }

    //endregion

}
