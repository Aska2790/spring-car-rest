package com.aska.development.carrestapi.services.mapper;

import com.aska.development.carrestapi.auxiliary.mapper.Mapper;
import com.aska.development.carrestapi.entities.CarEntity;
import com.aska.development.carrestapi.services.dto.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements Mapper<Car, CarEntity> {
    @Override
    public CarEntity map(Car sourceItem) {
        CarEntity carEntity = new CarEntity();
        carEntity.setId(sourceItem.getId());
        carEntity.setManufacture(sourceItem.getManufacture());
        carEntity.setModel(sourceItem.getModel());
        carEntity.setType(sourceItem.getType());
        carEntity.setCountry(sourceItem.getCountry());
        carEntity.setCreateDate(sourceItem.getCreateDate());
        return carEntity;
    }
}
