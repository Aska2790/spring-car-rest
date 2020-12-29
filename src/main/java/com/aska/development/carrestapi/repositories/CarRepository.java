package com.aska.development.carrestapi.repositories;

import com.aska.development.carrestapi.entities.Car;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long>, JpaSpecificationExecutor<Car> {
    Optional<Car> findById(Long id);

    List<Car> findAll();
}
