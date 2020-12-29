package com.aska.development.carrestapi.services;

import com.aska.development.carrestapi.entities.Car;
import com.aska.development.carrestapi.exceptions.NotFoundException;
import com.aska.development.carrestapi.repositories.CarRepository;
import com.aska.development.carrestapi.repositories.CarSpecificationBuilder;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    //region Fields

    private static final int KEY_GROUP_INDEX = 1;
    private static final int OPERATION_GROUP_INDEX = 2;
    private static final int VALUE_GROUP_INDEX = 3;

    @Value("${car.search.criteria.pattern}")
    private String mPattern;

    private CarRepository mRepository;

    //endregion

    //region Constructors

    public CarServiceImpl(CarRepository repository) {
        mRepository = repository;
        Objects.requireNonNull(mRepository);
    }

    //endregion

    //region Methods


    @Override
    public List<Car> findAll(String filter) {
        if(filter != null && !filter.isEmpty()){
            Pattern pattern = Pattern.compile(mPattern,
                    Pattern.UNICODE_CHARACTER_CLASS);

            Matcher matcher = pattern.matcher(filter + ",");

            var builder = CarSpecificationBuilder.builder();
            while (matcher.find()) {
                var key = matcher.group(KEY_GROUP_INDEX);
                var operation = matcher.group(OPERATION_GROUP_INDEX);
                var value = matcher.group(VALUE_GROUP_INDEX);
                var criteria = new CarSearchCriteria(key, operation, value);
                builder.addCriteria(criteria);
            }

            var specification = builder.build();
            if(specification != null){
                return mRepository.findAll(specification);
            }
        }
        return mRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Car findById(Long id) {
        Car car = mRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        return car;
    }

    @Transactional(readOnly = true)
    public List<Car> findAll() {
        return mRepository.findAll();
    }

    public void delete(Long id) {
        Car car = mRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mRepository.delete(car);
    }

    public void save(Car car) {
        Car entity = mRepository.save(car);
        car.setId(entity.getId());
    }

    //endregion

}
