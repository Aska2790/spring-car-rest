package com.aska.development.carrestapi.services.mapper;

import com.aska.development.carrestapi.auxiliary.mapper.Mapper;
import com.aska.development.carrestapi.entities.CarEntity;
import com.aska.development.carrestapi.services.dto.Car;
import org.springframework.stereotype.Component;

@Component
public class CarEntityMapper implements Mapper<CarEntity, Car> {
    @Override
    public Car map(CarEntity sourceItem) {
        return new Car()
                .setId(sourceItem.getId())
                .setManufacture(sourceItem.getManufacture())
                .setModel(sourceItem.getModel())
                .setType(sourceItem.getType())
                .setCountry(sourceItem.getCountry())
                .setCreateDate(sourceItem.getCreateDate());
    }
}
