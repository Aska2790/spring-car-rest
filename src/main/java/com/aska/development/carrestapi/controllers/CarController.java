package com.aska.development.carrestapi.controllers;

import com.aska.development.carrestapi.services.dto.Car;
import com.aska.development.carrestapi.services.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cars")
public class CarController {

    //region Fields

    private CarService mService;

    //endregion

    //region Constructors

    public CarController(CarService service) {
        mService = service;
    }

    //endregion

    //region Methods

    @GetMapping
    public List<Car> select(@RequestParam Map<String, String> params) {
        if (params.isEmpty()) {
            return mService.findAll();
        }
        return mService.findAll(params);
    }

    @GetMapping("{id}")
    public Car select(@PathVariable Long id) {
        return mService.findById(id);
    }

    @PostMapping
    public Car create(@RequestBody Car car) {
        mService.insert(car);
        return car;
    }

    @PutMapping
    public Car update(@RequestBody Car car) {
        mService.update(car);
        return car;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        mService.delete(id);
    }

    //endregion

}
