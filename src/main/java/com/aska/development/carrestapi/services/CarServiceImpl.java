package com.aska.development.carrestapi.services;

import com.aska.development.carrestapi.auxiliary.filter.FilterByRequestParam;
import com.aska.development.carrestapi.entities.CarEntity;
import com.aska.development.carrestapi.exceptions.NotFoundException;
import com.aska.development.carrestapi.repositories.CarRepository;
import com.aska.development.carrestapi.services.dto.Car;
import com.aska.development.carrestapi.services.filter.BaseCarFilter;
import com.aska.development.carrestapi.services.mapper.CarEntityMapper;
import com.aska.development.carrestapi.services.mapper.CarMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    //region Fields

    private CarRepository mRepository;
    private CarMapper mDirectMapper;
    private CarEntityMapper mReverseMapper;
    private List<BaseCarFilter> mFilters;

    //endregion

    //region Constructors

    public CarServiceImpl(CarRepository repository,  List<BaseCarFilter> filters,
                          CarMapper directMapper, CarEntityMapper reverseMapper) {

        mRepository = repository;
        mDirectMapper = directMapper;
        mReverseMapper = reverseMapper;
        mFilters = filters;

        Objects.requireNonNull(mRepository);
        Objects.requireNonNull(mDirectMapper);
        Objects.requireNonNull(mReverseMapper);
        Objects.requireNonNull(mFilters);
    }

    //endregion

    //region Methods

    @Transactional(readOnly = true)
    public Car findById(Long id) {
        CarEntity carEntity = mRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        return new CarEntityMapper().map(carEntity);
    }

    @Transactional(readOnly = true)
    public List<Car> findAll() {
        return mRepository.findAll()
                .stream()
                .map(mReverseMapper::map)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Car> findAll(Map<String, String> params) {
        return mRepository.findAll()
                .stream()
                .map(mReverseMapper::map)
                .filter(new CarFilter(mFilters, params))
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        CarEntity carEntity = mRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mRepository.delete(carEntity);
    }

    public void update(Car car) {
        CarEntity isPresent = mRepository.findById(car.getId())
                .orElseThrow(NotFoundException::new);

        CarEntity carEntity = mDirectMapper.map(car);
        carEntity = mRepository.save(carEntity);
        car.setId(carEntity.getId());
    }

    public void insert(Car car) {
        CarEntity carEntity = mDirectMapper.map(car);
        carEntity = mRepository.save(carEntity);
        car.setId(carEntity.getId());
    }

    //endregion

    //region Nested

    public static class CarFilter implements Predicate<Car> {
        //region Fields

        private Map<String, String> mParams;
        private List<BaseCarFilter> mFilters;
        //endregion

        //region Properties
        //endregion

        //region Constructors

        public CarFilter(List<BaseCarFilter> filters, Map<String, String> params) {
            mFilters = filters;
            mParams = params;
            Objects.requireNonNull(mFilters);
        }

        //endregion

        //region Methods

        @Override
        public boolean test(Car car) {

            //Если не передали параметры
            if(mParams == null){
                return true;
            }

            boolean isPassed = false;
            for (FilterByRequestParam<Car> filter : mFilters) {
                String paramName = filter.getRequirementParamName();
                if (mParams.containsKey(paramName)) {
                    String param = mParams.get(paramName);
                    isPassed = filter.test(car, param);

                    // Если один фильтр не прошел проверку то остальные не стоит проверять
                    if (!isPassed) {
                        return false;
                    }
                }
            }
            return isPassed;
        }

        //endregion

    }

    //endregion
}
