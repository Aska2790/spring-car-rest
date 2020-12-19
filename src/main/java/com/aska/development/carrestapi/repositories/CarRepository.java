package com.aska.development.carrestapi.repositories;

import com.aska.development.carrestapi.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<CarEntity, Long>, JpaSpecificationExecutor<CarEntity> {
    Optional<CarEntity> findById(Long id);

    List<CarEntity> findAll();
}
